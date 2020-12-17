### 1. CheckStyle

#### 1) 목적

* 자바 소스 파일을 읽어서 소스 코드 표준에 위반되는 것들을 체크
* 개발자의 취향에 따라 변수명, 메소드명, 작성법 등이 달라 발생하는 문제를 해결하기 위해서 만들어짐

#### 2) 장점

* 정해진 코딩 규약에 위반되는 것들을 검사해줌
* 직접 코딩 규약을 만들어 사용 가능 

#### 3) 단점

* 실제 버그를 찾을 수 없음

#### 4) 설치

① 소프트웨어 설치

* Help > Install New Software
* http://eclipse-cs.sf.net/update/ 주소 추가
* Checkstyle 플러그인 선택

② Gradle

* build.gradle에 ```apply plugin: 'checkstyle'``` 추가

* checkstyle.xml 작성

* build.gradle에 checkstyle 태스크 정의

  ```
  checkstyle {
    ignoreFailures = true // 분석결과 예외가 발생하면 빌드실패 발생시키는 것을 제외
      configFile = file("config/checkstyle/checkstyle.xml") // 작성한 checkstyle 파일 지정
      reportsDir = file("${buildDir}/checkstyle-output") // 리포트 파일이 위치할 디렉토리 지정
  }
   
  checkstyleMain {
      reports {
          xml.destination = file("${checkstyle.reportsDir}/checkstyle-report.xml") // 리포트 파일의 위치 및 파일명 지정
      }
  }
  ```

* ```>gradlew clean build```

#### 5) 기본 설정

#### 6) 커스텀 설정

> GNU Lesser General Public License