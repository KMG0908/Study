## 필터(Filter)와 인터셉터(Interceptor)
![그림](https://t1.daumcdn.net/cfile/tistory/997BAE4D5C8B3F7D10)
### 필터
* J2EE 표준스펙에 정의되어 있는 기능
  * web.xml에 설정
* DispatcherServlet 앞단에서 정보 처리

### 인터셉터
* SpringFramework에서 자체적으로 제공하는 기능
  * servlet-context.xml 또는 dispatcher-servlet.xml에 interceptor를 등록
* DispatcherServlet에서 Handler(Controller)로 가기전에 정보 처리

> 이 글은 https://cornswrold.tistory.com/56 를 바탕으로 작성되었습니다.
