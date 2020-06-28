## JWT(Json Web Token)
### 개념
* Json 포맷을 이용하여 사용자에 대한 속성을 저장하는 Claim 기반의 Web Token
* 토큰 자체를 정보로 사용하는 Self-Contained 방식으로 정보를 전달

### 구조
![구조](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fc3oKza%2FbtqArSHlIuP%2FQQU4oljS5KxyNgv4651Nk1%2Fimg.png)
* 각 부분은 Base64로 인코딩
* . 구분자를 사용

#### Header
* **typ**과 **alg** 두 가지 정보로 구성
  * typ: 토큰의 타입을 지정 ex) JWT
  * alg: 알고리즘 방식을 지정하며, 서명(Signature) 및 토큰 검증에 사용 ex) HS256(SHA256) 또는 RSA
  
#### Payload
* 토큰에서 사용할 정보의 조각들인 클레임(Claim)이 담겨 있음

#### Signature
* 토큰을 인코딩하거나 유효성 검증을 할 때 사용하는 고유한 암호화 코드

> 이 글은 https://mangkyu.tistory.com/56 를 바탕으로 작성되었습니다.
