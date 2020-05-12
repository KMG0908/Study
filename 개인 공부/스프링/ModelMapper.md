```java
@Getter
@Setter
@NoArgsConstructor
@ToString
public class NovelDTO {
	private int novelPk;
	private String novelName;
	private String novelIntro;
	private String novelImage;
	private boolean novelLimit;
	private boolean novelOpen;
	private int novelStatus;
	private boolean novelOnly;
	private Date novelUpdatedAt;
	private MemberDTO member;
}
```

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private int memPk;
	private String memId;
	private String memEmail;
	private String memPw;
	private String memNick;
	private String memPhone;
	private String memBirth;
	private boolean memGender;
}
```

NovelDTO 안에 MemberDTO가 존재하고 있어 소설에 대한 정보를 얻어오면 그 소설을 작성한 회원의 정보까지 리턴이 되는 상황이 발생했다. 리턴되는 회원의 정보는 memPk, memNick이면 충분할 것 같다는 생각이 들어 Builder를 활용하기로 했다.

```java
@Builder(builderClassName="Author", builderMethodName="Author")
public MemberDTO(int memPk, String memNick) {
	super();
	this.memPk = memPk;
	this.memNick = memNick;
}
```

```java
@Builder(builderClassName="Test", builderMethodName="Test")
public NovelDTO(int novelPk, String novelName, String novelIntro, String novelImage, boolean novelLimit,
		boolean novelOpen, int novelStatus, boolean novelOnly, Date novelUpdatedAt, MemberDTO member) {
	super();
	this.novelPk = novelPk;
	this.novelName = novelName;
	this.novelIntro = novelIntro;
	this.novelImage = novelImage;
	this.novelLimit = novelLimit;
	this.novelOpen = novelOpen;
	this.novelStatus = novelStatus;
	this.novelOnly = novelOnly;
	this.novelUpdatedAt = novelUpdatedAt;
	this.member = MemberDTO.Author()
			.memPk(member.getMemPk())
			.memNick(member.getMemNick())
			.build();
}
```
이런 식으로 바꿨는데... 아니나 다를까 바로 에러가 터지더라.  
entity -> dto 변환 작업을 modelmapper를 통해서 하고 있었는데 `modelMapper.map(novel, NovelDTO.class)`에서는 잘만 변환되던 것이 `modelMapper.map(novel, NovelDTO.Test.class)`로 바꾸니까 값이 안 들어가고 계속해서 null 값이 들어갔다.  
한참 동안 검색을 거듭하다가 찾은 방법은 아래와 같다.
```java
Configuration builderConfiguration = modelMapper.getConfiguration().copy();
builderConfiguration.setDestinationNamingConvention((name, type) -> true);
builderConfiguration.setDestinationNameTransformer((name, type) -> name);

modelMapper.createTypeMap(Novel.class, NovelDTO.Test.class, builderConfiguration);
```
이 방법으로 해결됐다면 정말 좋았겠지만.... 안타깝께도 소설에 해당하는 정보는 들어갔지만 그 안에 있던 회원에 대한 정보는 여전히 null 값이었다.
구글링을 하며 공식 메뉴열을 열심히 뒤져본 결과... 아래 방식을 통해 겨우 해결했다!
```java
modelMapper.createTypeMap(Novel.class, NovelDTO.Test.class, builderConfiguration)
	    	.addMappings(mapper -> mapper.<MemberDTO>map(src -> src.getMember(), 
	    			(dest, v) -> dest.member(v)));
```
덕분에 memPk, memNick을 제외한 모든 정보를 null 값으로 처리하는 데 성공했다.
```
"data": {
   "novelPk": 1,
   "novelName": "aaa",
   "novelIntro": "aaa",
   "novelImage": "aaa",
   "novelLimit": true,
   "novelOpen": true,
   "novelStatus": 0,
   "novelOnly": true,
   "novelUpdatedAt": "2020-05-11T08:01:31.000+0000",
   "member": {
     "memPk": 1,
     "memId": null,
     "memEmail": null,
     "memPw": null,
     "memNick": "aaa",
     "memPhone": null,
     "memBirth": null,
     "memGender": false
   }
 }
```
하지만 안타깝게도 내가 원하는 결과는 아니었다. 
```
"data": {
   "novelPk": 1,
   "novelName": "aaa",
   "novelIntro": "aaa",
   "novelImage": "aaa",
   "novelLimit": true,
   "novelOpen": true,
   "novelStatus": 0,
   "novelOnly": true,
   "novelUpdatedAt": "2020-05-11T08:01:31.000+0000",
   "member": {
     "memPk": 1,
     "memNick": "aaa"
   }
 }
```
member 객체에는 memPk와 memNick만 넣고 싶었는데.... 여기서 코드를 어떻게 수정해야 하는지 전혀 감이 안오더라.  
시간은 한정되어 있어서 일단은 memPk, memNick만 가지고 있는 DTO를 만드는 방식으로 진행하기로 했다.  
NovelDTO만을 위한 멤버 객체의 DTO를 따로 만드는 것도 생각 안한 건 아니지만 @Builder로 해결할 수 있을 것 같아 한참동안 붙들고 있었는데.... 결국 DTO를 만드는 방식으로 진행하게 되어 너무 허무하다ㅠ  
