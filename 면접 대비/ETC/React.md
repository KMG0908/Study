## 리액트(React)
### 개념
* 페이스북에서 개발한 유저인터페이스 라이브러리
* 재사용 가능한 UI를 생성 할 수 있게 해준다.

### 장점
* React는 JavaScript 객체 형태의 Virtual DOM 을 사용하여 어플리케이션의 성능을 향상시킴 (JavaScript Virtual DOM 처리가 실제 DOM 보다 빠르기 때문)
* 서버 & 클라이언트 사이드 렌더링 지원을 통해 브라우저측의 초기 렌더링 딜레이를 줄이고, SEO 호환도 가능해짐
* Component 의 가독성이 매우 높고 간단하여 쉬운 유지보수, 간편한 UI 수정 및 재사용 용이
* React는 프레임워크가 아닌 라이브러리기 때문에 다른 프레임워크와 혼용 가능

### 단점
* VIEW ONLY, VIEW 이외의 기능은 써드파티 라이브러리(Third party library, =패키지, 모듈로 불리기도함)를 이용하거나 직접 구현해야함
* IE8 이하 지원하지 않음 (IE8 이하 버전을 지원해야 할 경우 v0.14 버전을 사용 해야함)
* React는 inline-template 과 JSX 를 사용하는데, 일부 개발자들에게는 적응이 안 될 수 있음

> 이 글은 https://hyejin-dev.tistory.com/3 를 바탕으로 작성되었습니다.
