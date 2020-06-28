## MVVM
### 개념
* Model + View + View Model

### 구조
![구조](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FCiXz0%2FbtqBQ1iMiVT%2FstaXr7UO95opKgXEU01EY0%2Fimg.png)
* Model : 어플리케이션에서 사용되는 데이터와 그 데이터를 처리하는 부분
* View : 사용자에서 보여지는 UI 부분
* View Model : View를 표현하기 위해 만든 View를 위한 Model, View를 나타내 주기 위한 Model이자 View를 나타내기 위한 데이터 처리를 하는 부분

### 동작
1. 사용자의 Action들은 View를 통해 들어오게 된다.
2. View에 Action이 들어오면, Command 패턴으로 View Model에 Action을 전달한다.
3. View Model은 Model에게 데이터를 요청한다.
4. Model은 View Model에게 요청받은 데이터를 응답한다.
5. View Model은 응답 받은 데이터를 가공하여 저장한다.
6. View는 View Model과 Data Binding하여 화면을 나타낸다.

### 특징
* MVVM 패턴은 Command 패턴과 Data Binding 두 가지 패턴을 사용하여 구현되었다.
* Command 패턴과 Data Binding을 이용하여 View와 View Model 사이의 의존성을 없앴다.
* View Model과 View는 1:n 관계다.

### 장점
* MVVM 패턴은 View와 Model 사이의 의존성이 없다.
* Command 패턴과 Data Binding을 사용하여 View와 View Model 사이의 의존성 또한 없다.
* 각각의 부분은 독립적이기 때문에 모듈화 하여 개발할 수 있다.

### 단점
* View Model의 설계가 쉽지 않다.

> 이 글은 https://beomy.tistory.com/43 를 바탕으로 작성되었습니다.
