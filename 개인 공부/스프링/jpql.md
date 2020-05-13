# Native Query와 jpql에 대해서
## 1. 테이블 이름
#### Native Query `select * from member`
#### jpql `select m from Member m`
실제로 데이터베이스 테이블 이름은 member지만, jpql에서 member라고 쓸 경우 member라는 엔티티가 존재하지 않기 때문에 에러가 났다. jpql은 테이블 이름이 아닌 엔티티명(Member)이 와야 한다.  
같은 의미에서 속성명도 실제로 데이터베이스에서 사용하는 이름(`mem_pk`)이 아니라 엔티티에 선언된 변수명(`memPk`)로 해줘야 한다.  

## 2. join
#### Native Query `join(member) using(mem_pk)`
#### jpql `join n.member m`
Novel 안에 Member 객체가 들어있다고 가정했을 경우 jpql은 Novel 안의 Memeber를 조인하는 것만으로도 알아서 연관 필드로 조인을 해준다.  

### 3. group_concat
#### jpql에서는 function을 등록해줘야 한다!
여러개 시도해봤지만... 결과적으로 나한테 통한 건 클래스를 만들고, 프로퍼티에 그걸 등록해주는 방식이었다. 
```java
public class CustomMySQLDialect extends MySQL57Dialect {
	public CustomMySQLDialect() {
		super();
		
		registerFunction(
		    "group_concat",
		    new StandardSQLFunction(
		        "group_concat",
		        StandardBasicTypes.STRING
		    )
		);
	}
}
```
```xml
spring.jpa.database-platform=com.ssafy.config.CustomMySQLDialect
```

# 결과
### 전
```java
@Query(
  value = "select * from novel n "
    + "join member "
    + "using(mem_pk) "
    + "where n.novelName like %?1% ",
  countQuery = "select count(*) from novel n "
    + "join member "
    + "using(mem_pk) "
    + "where n.novelName like %?1% ",
  nativeQuery = true)
```
### 후
```java
@Query(
  value = "select new com.ssafy.model.entity.Novel(n.novelPk, n.novelName, n.novelIntro, "
    + "n.novelImage, n.novelLimit, n.novelOpen, n.novelStatus, n.novelOnly, "
    + "n.novelUpdatedAt, m, group_concat(g.genreName)) "
    + "from Novel n, Member m, NovelGenre ng, Genre g "
    + "where n.member.memPk = m.memPk "
    + "and n.novelPk = ng.novel.novelPk "
    + "and ng.genre.genrePk = g.genrePk "
    + "and n.novelName like %?1% ",
  countQuery = "select count(*) from Novel n "
    + "inner join n.member m "
    + "where n.novelName like %?1% ")
```
진짜 이것때문에 몇 시간을 날려먹은건지...... 
