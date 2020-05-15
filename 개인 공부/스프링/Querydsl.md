## 20200514
각 소설에 해당하는 선호작 수를 얻어오기 위해서는 `select count(*) from like_novel where novel_pk=n.novel_pk`라는 쿼리가 필요했고, 소설의 정보와 같이 리턴을 하기 위해서는 서브쿼리를 사용해야만 했다.  

**하지만 JPQL에서는 select 절에 서브쿼리를 사용할 수가 없다!** JPQL에서는 `where`과 `having`절에서만 서브쿼리를 사용하는 것이 가능하다.  

원하는 기능을 위해 JPQL을 Querydsl로 바꾸는 작업에 돌입했다. 그리고 오늘도 역시나... 오류의 늪에 빠져버렸다...

### Group Concat
`SQLExpressions.groupConcat(genre.genreName).as("novelName")`은 계속해서 NullPointer Exception이 떴고, 결과적으로 나는 `SimpleTemplate<String> simpleTemplate = Expressions.simpleTemplate(String.class, "group_concat({0})", genre.genreName)`을 활용해서 해결했다.

### Select 서브쿼리
```java
ExpressionUtils.as(
  JPAExpressions.select(likeNovel.likeNovelPk.count())
  .from(likeNovel)
  .where(likeNovel.novel.novelPk.eq(novel.novelPk)),
  "likes"
)
```
https://jojoldu.tistory.com/379 글 덕분에 Select 서브쿼리를 작성하는 법은 생각보다 쉬었다.

### 결과
#### 전
```java
@Query(
  value = "select new Novel(n.novelPk, n.novelName, n.novelIntro, "
    + "n.novelImage, n.novelLimit, n.novelOpen, n.novelStatus, n.novelOnly, "
    + "n.novelUpdatedAt, m, group_concat(g.genreName)) "
    + "from Novel n, Member m, NovelGenre ng, Genre g, LikeNovel ln "
    + "where n.member.memPk = m.memPk "
    + "and n.novelPk = ng.novel.novelPk "
    + "and ng.genre.genrePk = g.genrePk "
    + "group by n.novelPk ",
  countQuery = "select count(*) from Novel n "
    + "inner join n.member m ")
```

#### 후
```java
SimpleTemplate<String> simpleTemplate = Expressions.simpleTemplate(String.class, "group_concat({0})", genre.genreName);
JPAQuery<Novel> query = 
  queryFactory.select(
  Projections.constructor(Novel.class, 
  novel.novelPk.as("novelPk"),
  novel.novelName.as("novelName"),
  novel.novelIntro.as("novelIntro"),
  novel.novelImage.as("novelImage"),
  novel.novelLimit.as("novelLimit"),
  novel.novelOpen.as("novelOpen"),
  novel.novelStatus.as("novelStatus"),
  novel.novelOnly.as("novelOnly"),
  novel.novelUpdatedAt.as("novelUpdatedAt"),
  novel.member.as("member"), 
  simpleTemplate.as("genreName"),
  ExpressionUtils.as(
    JPAExpressions.select(likeNovel.likeNovelPk.count())
      .from(likeNovel)
      .where(likeNovel.novel.novelPk.eq(novel.novelPk)),
      "likes"
      )
    )
  )
  .from(novel)
  .join(novel.member, member)
  .join(novelGenre).on(novelGenre.novel.novelPk.eq(novel.novelPk))
  .join(genre).on(novelGenre.genre.genrePk.eq(genre.genrePk))
  .groupBy(novel.novelPk);
 ```
 
하고 나니까 진짜..... 별 거 아닌데 아무래도 JPQL도 그렇고 Querydsl도 그렇고 처음 다뤄서 그런지 많이 헤매게 되는 것 같다. 이것도 점차 나아지겠지....  

## 20200515
likes로 별칭을 준 걸 바탕으로 order by를 하고 싶었는데 별칭 준 거 앞에 계속해서 테이블 이름(`novel.likes`)이 붙어서 에러가 났다.  
해결 방법은 생각보다 간단했다.
```
NumberPath<Long> likes = Expressions.numberPath(Long.class, "likes"); 
```
선언 후에 `ExpressionUtils.as` 부분에  `"likes"`를 선언한 변수 `likes`로 바꾼 뒤 `order by(likes)`로 하니까 끝!
