## DispatcherServlet
### 개념
* Servlet Container에서 HTTP프로토콜을 통해 들어오는 모든 요청을 프레젠테이션 계층의 제일앞에 둬서 중앙집중식으로 처리해주는 프론트 컨트롤러(Front Controller)
  * 프론트 컨트롤러: 주로 서블릿 컨테이너의 제일 앞에서 서버로 들어오는 클라이언트의 모든 요청을 받아서 처리해주는 컨트롤러, MVC 구조에서 함께 사용되는 패턴
* 해당 어플리케이션으로 들어오는 모든 요청을 핸들링

### 흐름
![흐름](https://t1.daumcdn.net/cfile/tistory/99F8E4335A06F70930)

> 이 글은 https://mangkyu.tistory.com/18 를 바탕으로 작성되었습니다.
