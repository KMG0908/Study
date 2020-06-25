## 제네릭(Generic)
### 개념
* 클래스 내부에서 사용하는 데이터의 타입(Type)을 클래스의 인스턴스를 생성할 때 결정하는 것
![예시](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcKJc01%2Fbtqv0yfQWxl%2FxyKRLszrlst7OlNRruz620%2Fimg.png)

### 장점
#### 1. 컴파일 시 강한 타입 체크를 할 수 있다.
* 실행시 타입 에러가 나는 것보다 컴파일 시에 미리 타입을 강하게 체크해서 에러를 사전에 방지한다.
#### 2. 타입 변환(casting)을 제거한다.
* 비제네릭 코드는 불필요하게 타입 변환을 하기 때문에 프로그램 성능에 악영향을 미친다.

> 이 글은 https://lktprogrammer.tistory.com/177 와 https://cornswrold.tistory.com/180 를 바탕으로 작성되었습니다.
