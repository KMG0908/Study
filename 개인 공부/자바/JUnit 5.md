### 1. JUnit 5란?

* **JUnit 5** = **JUnit Platform** + **JUnit Jupiter** + **JUnit Vintage**
* Junit의 이전 버전과 다르게 세 개의 서로 다른 하위 프로젝트로 구성

#### 1) JUnit Platform

* JVM 위에서 테스트를 실행시키는 기반 역할
* 플랫폼에서 실행되는 테스트 프레임워크 개발을 위한 테스트엔진 API 정의
* command line에서 플랫폼을 실행할 console launcher와 JUnit 4 기반 환경의 플랫폼에서 테스트엔진을 실행할 수 있는 JUnit 4 based Runner 제공

#### 2) JUnit Jupiter

* JUnit 5에서 테스트와 Extension을 작성하기 위한 새로운 프로그래밍 모델과 확장 모델의 조합
* JUnit 5로 작성된 테스트를 실행시키는 테스트 엔진을 제공

#### 3) JUnit Vintage

* JUnit3, 4로 작성된 테스트를 실행시키는 테스트 엔진을 제공

* dependency에 junit-vintage-engine 추가하여 사용

  JUnit 5(org.junit.jupiter.api)와는 패키지(org.junit)이 다르기 때문에 충돌이 발생하지 않음

> JUnit 5는 자바 8 이상의 런타임 환경을 요구하지만 이전 버전의 JDK로 컴파일 된 코드도 테스트 할 수 있음



### 2. 테스트 작성하기

#### 2.1. Annotation

* 프레임워크를 확장하기 위해 다음과 같은 어노테이션을 제공

| Annotation             | 설명                                                         |
| ---------------------- | ------------------------------------------------------------ |
| @Test                  | 테스트 메서드임을 나타낸다. JUnit Jupiter의 테스트 extension은 자체 전용 어노테이션에 기초하여 작동되기 때문에 Junit 4의 @Test와 다르게 어떤 속성도 선언하지 않는다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @ParameterizedTest     | 매개 변수화된 테스트임을 나타낸다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @RepeatedTest          | 반복 테스트를 위한 테스트 템플릿임을 나타낸다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @TestFactory           | 동적 테스트를 위한 테스트 팩토리임을 나타낸다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @TestTemplate          | 등록된 제공자가 반환하는 호출 컨텍스트 수에 따라 여러 번 호출되도록 설계된 테스트 케이스용 템플릿임을 나타낸다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @TestMethodOrder       | 어노테이션이 있는 테스트 클래스에 대한 테스트 메서드 실행 순서를 구성하는 데 사용된다. JUnit 4의 @FixMethodOrder와 유사하다. 이러한 어노테이션은 상속된다. |
| @TestInstance          | 어노테이션이 있는 테스트 클래스에 대한 테스트 인스턴스 생명주기를 구성하는 데 사용된다. 이러한 어노테이션은 상속된다. |
| @DisplayName           | 테스트 클래스나 테스트 메서드의 사용자 정의 표시 이름을 선언한다. 이러한 어노테이션은 상속되지 않는다. |
| @DisplayNameGeneration | 테스트 클래스의 사용자 정의 표시 이름 생성기를 선언한다. 이러한 어노테이션은 상속된다. |
| @BeforeEach            | 각각의 테스트 메서드(@Test, @RepeatedTest, @ParameterizedTest, @TestFactory)의 실행 전에 호출되어 처리된다. JUnit 4의 @Before과 유사하다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @AfterEach             | 각각의 테스트 메서드(@Test, @RepeatedTest, @ParameterizedTest, @TestFactory)의 실행 후에 호출되어 처리된다. JUnit 4의 @After와 유사하다. 이러한 메서드는 재정의되지 않는 한 상속된다. |
| @BeforeAll             | 클래스에 존재하는 모든 메서드가 실행되기 전에 한 번만 호출되어 처리된다. JUnit 4의 @BeforeClass와 유사하다. 이러한 메서드는 숨겨지거나 재정의되지 않는 한 상속되며 클래스별 테스트 인스턴스 생명주기를 사용하지 않는 경우 정적(static)이어야 한다. |
| @AfterAll              | 클래스에 존재하는 모든 메서드가 실행된 후에 한 번만 호출되어 처리된다. JUnit 4의 @AfterClass와 유사하다. 이러한 메서드는 숨겨지거나 재정의되지 않는 한 상속되며 클래스별 테스트 인스턴스 생명주기를 사용하지 않는 경우 정적(static)이어야 한다. |
| @Nested                | 정적이 아닌 중첩 테스트 클래스임을 나타낸다. 클래스별 테스트 인스턴스 생명주기를 사용하지 않는 한 @BeforeAll과 @AfterAll 메서드는 @Nested 테스트 클래스에서 사용될 수 없다. |
| @Tag                   | 클래스 또는 메서드 레벨에서 필터링 테스트를 위한 태그를 선언하는 데 사용된다. TestNG의 테스트 그룹이나 JUnit 4의 카테고리와 유사하다. 이러한 어노테이션은 클래스 레벨에서는 상속되지만 메서드 레벨에서는 상속되지 않는다. |
| @Disabled              | 테스트 클래스나 테스트 메서드를 비활성화 하는 데 사용된다. JUnit 4의 @Ignore와 유사하다. 이러한 어노테이션은 상속되지 않는다. |
| @Timeout               | 실행이 지정된 기간을 초과하는 경우 테스트, 테스트 팩토리, 테스트 탬플릿, 라이프 사이클 메소드가 실패하는 데 사용된다. 이러한 어노테이션은 상속된다. |
| @ExtendWith            | extension을 선언적으로 등록할 때 사용된다. 이러한 어노테이션은 상속된다. |
| @RegisterExtension     | 필드를 통해 프로그래밍 방식으로 extension을 등록할 때 사용된다. 이러한 필드는 숨겨지지 않는 한 상속된다. |
| @TempDir               | 라이프 사이클 메서드나 테스트 메서드에서 필드 주입 또는 매개변수 주입을 통해 임시 디렉터리를 제공하는 데 사용된다. org.junit.jupiter.api.io 패키지에 위치하고 있다. |

##### 2.1.1. Meta-Annotation과 Composed Annotation

* JUnit Jupiter 어노테이션은 메타 어노테이션으로 사용될 수 있다. 

* 즉, 메타 어노테이션의 의미를 자동으로 상속받을 수 있는 조합 어노테이션을 정의할 수 있다. 

* 커스텀 어노테이션을 만들고 JUnit 5에 적용시킬 수 있다.

  ```java
  @Target({ ElementType.METHOD })
  @Retention(RetentionPolicy.RUNTIME)
  @DisplayName("CustomTest")
  @Test
  public @interface CustomTest {
      
  }
  ```

  생성한 Annotation은 아래와 같이 사용한다.

  ```java
  @CustomTest
  void myCustomTest() {
    
  }
  ```

#### 2.2. 테스트 클래스와 메서드

##### Test Class

* 최소한 하나의 테스트 메서드를 포함하는 최상위 클래스로, static 멤버 클래스 또는 @Nested 클래스
* 테스트 클래스는 abstract이 아니어야 하며, 단일 생성자가 있어야 한다.

##### Test Method 

* @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate를 사용하여 직접 어노테이션을 달거나 메타 어노테이션을 단 인스턴스 메서드

##### Lifecycle Method

* @BeforeAll, @AfterAll, @BeforeEach, @AfterEach를 사용하여 직접 어노테이션을 달거나 메타 어노테이션을 단 메서드

테스트 메서드 및 라이프 사이클 메서드는 현재 테스트 클래스 내에서 로컬로 선언되거나 슈퍼 클래스에서 상속되거나 인터페이스에서 상속될 수 있다. 또한 테스트 메서드와 라이프 사이클 메서드는 abstract으로 선언되어서는 안된다.

> 테스트 클래스, 테스트 메서드, 라이프 사이클 메서드는 public일 필요는 없지만, private이어서는 안된다.

#### 2.3. Display Name

테스트 클래스 및 테스트 메서드는 @DisplayName을 통해 사용자 정의 표시 이름(공백, 특수문자, 이모티콘 포함)을 선언할 수 있으며 이 이름은 테스트 리포트와 테스트 실행자 및 IDE에  표시된다.

```java
public class MemberServiceTest {
    // 기존 방식
    @Test
    public void 멤버_목록_조회() {
        
    }
    
    // JUnit 5 방식
    @Test
    @DisplayName("멤버 목록 조회")
    public void getMemberListTest() {
        
    }
}
```

##### 2.3.1. Display Name Generators

* JUnit Jupiter는 @DisplayNameGeneration 을 이용하여 구성할 수 있는 custom DisplayNameGenerator을 지원한다.
* @DisplayName을 통해 제공된 값은 DisplayNameGenerator으로 생성된 것보다 우선된다.

#### 2.4. Assertions(단정문)

* JUnit Jupiter에는 JUnit 4에 있는 많은 Assertion Method가 포함되어 있으며 Java 8 람다와 함께 사용하기 적합한 몇가지를 추가하였다.
* 모든 메서드는 org.junit.jupiter.api.Assertions의 static 메서드로 정의되어 있다.
* assertTimeout() , assertAll(), assertEqaul() , assertTrue() 등을 람다를 이용하여 작성할 수 있다.

> **선점 시간 제한 assertTimeoutPreemptively()**
>
> 선언적 타임 아웃(declarative timeouts)과는 달리 Assertions 클래스의 다양한 assertTimeoutPreemptively() 메서드는 제공된 코드 executable또는 supplier 호출 코드의 스레드와 다른 스레드에서 실행된다. executable 또는 supplier 내에서 실행되는 코드가 java.lang.ThreadLocalstorage에 의존하는 경우 바람직하지 않은 부작용을 초래할 수 있다. 

##### 2.4.1. Kotlin Assertion Support

* JUnit Jupiter는 Kotlin에서 사용하기에 적합한 몇 가지 Assetion 방법도 제공한다.

##### 2.4.2. Third-party Assertion Libraries

* JUnit Jupiter도 많은 기능을 제공하지만 필요에 따라 더 가독성 있고 유연한 기능들을 제공하는 AssertJ, Hamcrest 등 써드파티 라이브러리를 사용하는 것을 권장한다.

#### 2.5. Assumptions(전제문)

* Assertions과 마찬가지로 JUnit 5 Jupiter의 Assumptions Method들에는 JUnit 4의 Assumptions의 많은 메서드들이 포함되어 있고 람다를 활용한 추가적인 기능을 제공한다.
* 모든 메서드는 org.junit.jupiter.api.Assumptions의 static 메서드로 정의되어 있다.

#### 2.6. Disabling Tests(테스트 비활성화)

* @Disabled를 통해 특정 테스트 클래스 혹은 메서드들을 테스트에서 제외시킬 수 있다.

  ```java
  class DisabledTestsDemo {
      @Disabled("#42번 버그가 해결될 때까지 비활성화 됨")
      @Test
      void testWillBeSkipped() {
      }
  
      @Test
      void testWillBeExecuted() {
      }
  }
  ```

#### 2.7. Conditional Test Execution(조건부 테스트 실행)

* org.junit.jupiter.api.condition 이하의 Annotation을 통해 다양한 환경에 맞게 테스트를 활성화 혹은 비활성화시킬 수 있다.
* 운영체제, 자바 버전, 시스템 속성, 환경 변수 등에 따라 활성, 비활성이 가능하다.

##### 2.7.1. 운영체제 조건

* @EnabledOnOs, @DisabledOnOs를 통해 운영체제에 따라 테스트를 수행할 수 있다.

  ```java
  @Test
  @EnabledOnOs({ LINUX, MAC })
  void onLinuxOrMac() {
      
  }
  
  @Test
  @DisabledOnOs(WINDOWS)
  void notOnWindows() {
      
  }
  ```

##### 2.7.2. 자바 버전 조건

* @EnabledOnJre, @EnabledForJreRange, @DisabledOnJre, @DisabledForJreRange를 통해 자바 버전에 따라 테스트를 수행할 수 있다.

* OnJre의 경우 해당 버전에 대해 활성, 비활성이 가능하다.

* JreRange의 경우 버전에 대한 범위 지정, 최소, 최대 적용 버전 등을 지정할 수 있다.

  ```java
  @Test
  @EnabledOnJre({ JAVA_9, JAVA_10 })
  void onJava9Or10() {
     
  }
  
  @Test
  @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
  void fromJava9to11() {
      
  }
  ```

##### 2.7.3. 시스템 속성 조건

* @EnabledIfSystemProperty, @DisabledIfSystemProperty를 통해 JVM 시스템 속성에 따라 테스트를 수행할 수 있다.

* 속성을 통해 제공된 값은 정규식으로 해석된다.

  ```java
  @Test
  @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
  void onlyOn64BitArchitectures() {
     
  }
  
  @Test
  @DisabledIfSystemProperty(named = "ci-server", matches = "true")
  void notOnCiServer() {
      
  }
  ```

##### 2.7.4. 환경 변수 조건

* @EnabledIfEnvironmentVariable, @DisabledIfEnvironmentVariable을 통해 기본 운영체제에서 명명된 환경 변수에 따라 테스트를 수행할 수 있다.

* 속성을 통해 제공된 값은 정규식으로 해석된다.

  ```java
  @Test
  @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
  void onlyOnStagingServer() {
      
  }
  
  @Test
  @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
  void notOnDeveloperWorkstation() {
      
  }
  ```

##### 2.7.5. 사용자 지정 조건

* @EnabledIf, @DisabledIf를 통해 boolean 리턴을 기반으로 테스트를 수행할 수 있다.

  ```java
  @Test
  @EnabledIf("customCondition")
  void enabled() {
      
  }
  
  @Test
  @DisabledIf("customCondition")
  void disabled() {
      
  }
  
  boolean customCondition() {
      return true;
  }
  ```

#### 2.8. Tagging and Filtering(태킹 및 필터링)

* 테스트 클래스와 메서드는 @Tag를 통해 태그로 지정할 수 있다.
* 태그는 나중에 테스트 검색 및 실행을 필터링하는 데 사용될 수 있다.
* 테스트를 진행할 때 지정한 태그만 테스트를 진행하게 할 수 있다.

##### 2.8.1. 태그 규칙

* 태그는 null이거나 빈 칸일 수 없다.
* 잘린(선행 및 후행 공백이 제거되었음을 의미) 태그는 공백을 포함할 수 없다.
* 잘린 태그는 ISO 제어 문자를 포함할 수 없다.
* 잘린 태그는 다음 예약 문자를 포함할 수 없다.
  * , 
  * (
  * )
  * &
  * |
  * !

#### 2.9. Test Excution Order(테스트 실행 순서)

* 테스트 메서드는 의도적으로 불명확한 알고리즘을 사용하여 정렬된다.

  ```java
  class OrderTest {
      @Test
      void first() {
          System.out.println("First");
      }
  
      @Test
      void second() {
          System.out.println("Second");
      }
  
      @Test
      void third() {
          System.out.println("Third");
      }
  
      @Test
      void fourth() {
          System.out.println("Fourth);
      }
  
  }
  
  // 출력
  Fourth
  Second
  First
  Third
  ```

* Order Annotaiton을 사용하면 테스트 순서를 지정할 수 있다.

* @TestMethodOrder를 통해 MethodOrderer를 지정하며, 이는 사용자가 지정하거나 다음과 같이 기본적으로 제공되는 것을 사용할 수 있다.

  * DisplayName: DisplayName에 따라 영숫자 순으로 테스트 메서드를 정렬한다.
  * MethodName: 메서드 이름과 형식 매개 변수 목록에 따라 영숫자 순으로 테스트 메서드를 정렬한다.
  * OrderAnnotation: @Order를 통해 지정된 값에 따라 숫자 순으로 테스트 메서드를 정렬한다.
  * Random: 무작위로 테스트를 정렬하고 사용자 정의 seed 구성을 제공한다.
  * Alphanumeric: 이름과 형식 매개 변수 목록에 따라 영숫자 순으로 테스트 메서드를 정렬한다.

  ```java
  @TestMethodOrder(OrderAnnotation.class)
  class OrderTest {
      @Order(1)
      @Test
      void first() {
          System.out.println("First");
      }
  
      @Order(2)
      @Test
      void second() {
          System.out.println("Second");
      }
  
      @Order(3)
      @Test
      void third() {
          System.out.println("Third");
      }
  
      @Order(4)
      @Test
      void fourth() {
          System.out.println("Fourth");
      }
  }
  
  // 출력
  First
  Second
  Third
  Fourth
  ```

#### 2.10. Test Instance Lifecycle

* 개별 테스트 메소드를 개별적으로 실행하고 변경 가능한 테스트 인스턴스 상태로 인한 예기치 않는 부작용을 피하기 위해 JUnit은 각 TestMethod를 실행하기 전에 TestClass의 새 인스턴스를 작성한다.

* 메서드별 테스트 인스턴스 생명주기는 JUnit Jupiter의 기본 동작이며, JUnit의 이전 버전들과도 유사하다.

* PER_METHOD: test 함수 당 인스턴스가 생성된다.

  PER_CLASS: test 클래스 당 인스턴스가 생성된다.

* JUnit Jupiter가 동일한 테스트 인스턴스에서 모든 테스트 메서드를 실행하기를 원하는 경우, 테스트 클래스에 @TestInstance(Lifecycle.PER_CLASS)를 달아야 한다.

  * 이 모드를 사용하면 테스트 클래스당 새로운 인스턴스가 한 번 생성된다.
  * 따라서, 테스트 메서드가 인스턴스 변수에 저장된 상태에 의존하는 경우 @BeforeEach 또는 @AfterEach 를 통해 상태를 재설정해야 할 수 있다.
  * @BeforeAll, @AfterAll가 정적 메서드가 아니어도 되기 때문에 static이 없는 kotlin이나 @Nested에서 @BeforeAll과 @AfterAll을 사용할 수 있다.

#### 2.11. Nested Tests

* 테스트 클래스의 내부 클래스를 정의할 때 필요한 어노테이션이다.

* 내부 클래스이므로 static 지정이 불가능하기 때문에 BeforeAll, AfterAll 선언은 불가능하다.

* 단, 테스트 인스턴스 생명주기를 메서드 단위가 아닌 클래스 단위로 설정하면 사용이 가능하다.

  ```java
  class NestedExampleTest {
  	@BeforeAll
  	static void setUpBeforeClass() throws Exception {
  		System.out.println("@BeforeAll - Outer Class");
  	}
  
  	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  		System.out.println("@AfterAll - Outer Class");
  	}
  
  	@BeforeEach
  	void setUp() throws Exception {
  		System.out.println("@BeforeEach - Outer Class");
  	}
  
  	@AfterEach
  	void tearDown() throws Exception {
  		System.out.println("@AfterEach - Outer Class");
  	}
  
  	@Test
  	void outer_test() {
  		System.out.println("Outer Class test method");
  	}
  
  	@Nested
  	@TestInstance(Lifecycle.PER_CLASS)
  	class InnerClass {
  		@BeforeAll
  		void setUpBeforeClassInner() throws Exception {
  			System.out.println("@BeforeAll - Inner Class");
  		}
  
  		@AfterAll
  		void tearDownAfterClassInner() throws Exception {
  			System.out.println("@AfterAll - Inner Class");
  		}
  
  		@BeforeEach
  		void setUp() throws Exception {
  			System.out.println("@BeforeEach - Inner Class");
  		}
  
  		@AfterEach
  		void tearDown() throws Exception {
  			System.out.println("@AfterEach - Inner Class");
  		}
  
  		@Test
  		void inner_test() {
  			System.out.println("Inner Class test method");
  		}
  	}
  }
  
  // 출력
  @BeforeAll - Outer Class
  
  @BeforeEach - Outer Class
  Outer Class test method
  @AfterEach - Outer Class
  
  @BeforeAll - Inner Class
  
  @BeforeEach - Outer Class
  @BeforeEach - Inner Class
  Inner Class test method
  @AfterEach - Inner Class
  @AfterEach - Outer Class
  
  @AfterAll - Inner Class
  @AfterAll - Outer Class
  ```

#### 2.12. Dependency Injection for Constructors and Methods(생성자와 메서드에 대한 의존성 주입)

* JUnit 5 이전까지는 테스트 생성자와 메서드에 매개변수를 가질 수 없었다.
* JUnit 5에서는 테스트 생성자와 메서드에 매개변수를 가질 수 있고, 이는 의존성 주입을 가능하게 한다.
* ParameterResolver는 런타임 시 매개변수를 정의하는 특징이 있다.
* JUnit5 Jupiter에서는 등록된 ParameterResolver에 의해 매개변수를 사용할 수 있다.
* Jupiter에 등록된 ParameterResolver는 총 3가지로 TestInfo, RepetitionInfo, TestReporter ParameterResolver가 존재한다.
* 해당 ParameterResolver에 의해 TestInfo, RepetitionInfo, TestReporter를 매개변수로 가질 수 있다.

##### 1) TestInfoParameterResolver

- 생성자에 TestInfo를 통해 클래스의 DisplayName 혹은 Tag들을 테스트할 수 있다.
- 각 테스트에서 혹은 LifeCycle메서드에서 TestInfo를 사용하여 각 테스트들의 Tag와 DisplayName을 테스트할 수 있다.
- 이외에도 TestInfo에는 해당 테스트의 Class, Method들의 정보를 가져올 수 있다.

##### 2) RepetitionInfoParameterResolver

* @RepeatedTest, @BeforeEach, @AfterEach의 메서드 파라미터가 RepetitionInfo 타입인 경우, RepetitionInfoParameterResolver는 RepetitionInfo의 인스턴스를 제공한다.
* RepetitionInfo는 현재 반복 및 총 반복 횟수에 대한 정보를 검색하는데 사용될 수 있다.
* 하지만, RepetitionInfoParameterResolver는 @RepeatedTest의 외부 컨텍스트에서 등록되지 않는다.

##### 3) TestReporterParameterResolver

* 테스트 시 추가적인 데이터를 게시할 수 있다.
* reportingEntryPublished()를 통해 IDE에서 보거나 보고서에 포함할 수 있다.

#### 2.13. Test Interfaces and Default Methods(테스트 인터페이스 및 기본 메서드)

* 인터페이스 기본 메서드에 @Test, @RepeatedTest , @ParameterizedTest , @TestFactory, @TestTemplate, @BeforeEach, @AfterEach를 선언할 수 있다.

  ```java
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  interface InterfaceTest {
      @BeforeAll
      default void beforeAll(){
          System.out.println("InterfaceTest Before All");
      }
  
      @BeforeEach
      default void beforeEach(){
          System.out.println("InterfaceTest Before Each");
      }
  
      @AfterEach
      default void afterEach(){
          System.out.println("InterfaceTest After Each");
      }
  
      @AfterAll
      default void afterAll(){
          System.out.println("InterfaceTest After All");
      }
  }
  ```

* 해당 테스트를 구현하는 다른 테스트는 해당 인터페이스의 라이프 사이클을 물려받는다.

  ```java
  class SampleTest implements InterfaceTest {
      @BeforeAll
      void BeforeAll() {
          System.out.println("SampleTest Before All");
      }
  
      @BeforeEach
      void sample_BeforeEach() {
          System.out.println("SampleTest Before Each");
      }
  
      @Test
      void sampleTest(){
          System.out.println("Sample Test");
      }
  
      @AfterEach
      void sample_AfterEach() {
          System.out.println("SampleTest After Each");
      }
  
      @AfterAll
      void sample_AfterAll() {
          System.out.println("SampleTest After All");
      }
  }
  
  // 출력
  InterfaceTest Before All
  SampleTest Before All
  InterfaceTest Before Each
  SampleTest Before Each
  Sample Test
  SampleTest After Each
  InterfaceTest After Each
  SampleTest After All
  InterfaceTest After All
  ```

* 테스트 인터페이스나 테스트 클래스에 @TestInstance(Lifecycle.PER_CLASS) 어노테이션이 붙어있는 경우 @BeforeAll이나 @AfterAll은 테스트 인터페이스나 인터페이스 기본 메서드의 static 메소드에 선언될 수 있다.

#### 2.14. Repeated Tests

* JUnut Jupiter는 @RepeatedTest을 통해 해당 테스트의 반복 횟수를 지정하여 반복되는 테스트를 정의할 수 있다.

* 해당 테스트들은 일반 @Test와 생명주기가 동일하다.

  ```java
  @RepeatedTest(10)
  void repeatedTest() {
      
  }
  ```

#### 2.15. Parameterized Tests

* 이 테스트를 통해 다른 argument로 테스트를 여러 번 할 수 있다.

* @Test 메서드처럼 선언되지만 @ParameterizedTest를 대신 사용한다.

* @ValueSource를 통해 해당 파라미터의 값을 바인딩시킬 수 있다.

  ```java
  @ParameterizedTest
  @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
  void palindromes(String candidate) {
      assertTrue(StringUtils.isPalindrome(candidate));
  }
  ```

  ```
  palindromes(String) ✔
  ├─ [1] candidate=racecar ✔
  ├─ [2] candidate=radar ✔
  └─ [3] candidate=able was I ere I saw elba ✔
  ```

##### 2.15.1. 필수 설정

* 매개 변수화된 테스트를 사용하기 위해서는 junit-jupiter-params 종속성을 추가해야 한다.

##### 2.15.2. argument 사용하기

* 매개 변수화된 테스트는 일반적으로 argument source index 와 method parameter index 사이의 일대일 상관 관계에 따라 구성된 소스에서 직접 인수를 사용한다.

* 그러나, 매개 변수화된 테스트는 소스에서 인수를 메소드에 전달된 단일 오브젝트로 집계할 수 있도록 선택할 수도 있다. 

* 매개 변수화된 테스트는 다음 규칙에 따라 공식 매개 변수를 선언해야 한다.

  * 0개 이상의 인덱싱된 인수를 먼저 선언해야 한다.
  * 다음에 0개 이상의 aggregators를 선언해야 한다.
  * ParameterResolver가 제공하는 0개 이상의 인수는 마지막에 선언해야 한다.

  > 인덱싱된 인수는 인수 제공자가 제공한 인수의 주어진 인덱스에 대한 인수로, 메서드의 형식 매개 변수 목록에 있는 동일한 인덱스에서 매개 변수화된 메서드에 대한 인수로 전달된다.

  > Aggregator는 ArgumentsAccessor 유형의 파라미터 또는 @AggregateWith의 어노테이션을 갖고 있는 파라미터다.

##### 2.15.3. argument 근원

###### @ValueSource

* 단일 리터럴 값 배열을 지정할 수 있으며, 매개 변수화된 테스트 호출당 하나의 인수를 제공하는 데만 사용할 수 있다.
* 다음과 같은 유형의 리터럴 값이 지원된다.
  * short
  * byte
  * int
  * long
  * float
  * double
  * char
  * boolean
  * java.lang.String
  * java.lang.Class

###### Null and Empty sources

* 잘못된 입력이 들어올 때 코너 케이스를 확인하고 소프트웨어의 적절한 동작을 확인하기 위해서, 매개 변수화된 테스트에 null과 빈 값을 제공하는 것이 유용할 수 있다.
* 다음 어노테이션은 단일 인수를 허용하는 매개 변수화된 테스트의 null 및 빈 값으로 사용된다.
  * @NullSource
  * @EmptySource
  * @NullandEmtySource

###### @EnumSource

* 상수 클래스에 선언된 상수를 사용하는 편리한 방법을 제공한다.
* names 속성은 선택적으로 매개 변수를 사용할 수 있다.
* mode 속성 또한 사용할 수 있는데, 열거 형 상수 풀에서 이름을 제외하거나 정규식을 지정할 수 있다.

###### @MethodSource

* 테스트 클래스 또는 외부 클래스 하나 이상의 팩토리 메소드를 참조할 수 있다.
* 테스트 클래스에 @TestInstance (Lifecycle.PER_CLASS)로 어노테이션을 달지 않는 한 테스트 클래스 내의 팩토리 메소드는 static이어야 한다.

* 반면, 외부 클래스의 팩토리 메서드는 항상 static이어야 한다.
* 또한 이러한 팩토리 메서드는 인수를 허용하지 않아야 한다.
* 각 팩토리 메서드는 인수 스트림을 생성해야 하며, 스트림 내의 각 인수 세트는 어노테이션이 있는 메서드의 개별 호출에 대한 실제 인수로 제공된다.

###### @CsvSource

* 인수 목록을 쉼표로 구분된 값으로 표현할 수 있다.
* 작은 따옴표 ' 안의 내용을 문자로 사용한다.
* 아무 값도 입력되지 않은 ' '는 빈값이다.
* 반면, 완전히 빈 값은 null로 해석된다.

| 입력 예                                                      | 결과 인수 목록          |
| :----------------------------------------------------------- | :---------------------- |
| @CsvSource({ "apple, banana" })                              | "apple", "banana"       |
| @CsvSource({ "apple, 'lemon, lime'" }                        | "apple", "lemon, lime"  |
| @CsvSource({ "apple, ''" })                                  | "apple", ""             |
| @CsvSource({ "apple, " })                                    | "apple", null           |
| @CsvSource(value = { "apple, banana, NIL" }, nullValues = "NIL") | "apple", "banana", null |

###### @CsvFileSource

* 클래스 경로 또는 로컬 파일 시스템에서 CSV 파일을 사용할 수 있다.
* 기본 구분 기호는 쉼표(,)이지만 delimiter 속성을 설정하여 다른 문자를 사용할 수도 있다.

###### @ArgumentsSource

* 재사용 가능한 사용자 정의를 지정하는 데 사용할 수 있다.
* ArgumentsProvider의 구현은 ArgumentsProvider 최상위 클래스 또는 static중첩 클래스 로 선언되어야 한다.

##### 2.15.4. Argument conversion(인수 변환)

###### Widening Conversion(확장 변환)

* JUnit Jupiter는 @ParameterizedTest에 제공된 인수에 대해 기본형 확장 변환을 제공한다.
* 예를 들어,  @ValueSource (ints = {1, 2, 3})로 주석이 달린 매개 변수화 된 테스트는 int 유형의 인수뿐만 아니라 long, float 또는 double 유형의 인수도 허용하도록 선언할 수 있다.

###### Implicit Conversion(암시적 변환)

* @CsvSource와 같은 사용 사례를 지원하기 위해 JUnit Jupiter는 여러 내장 암시적 유형 변환기를 제공한다. 

* 변환 프로세스는 각 메소드 매개 변수의 선언된 유형에 따라 다르다.

* 예를 들어, @ParameterizedTest가 TimeUnit 유형의 매개 변수를 선언하고 선언된 소스에서 제공한 실제 유형이 문자열인 경우 문자열은 해당 TimeUnit 열거 상수로 자동 변환된다.

* 10 진, 16 진 및 8 진 문자열 리터럴은 바이트, short, int, long 및 박스형 대응 문자의 정수 유형으로 변환된다.

  https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit

###### Fallback String-to-Object Conversion

* JUnit Jupiter는 문자열에서 위 표에 나열된 대상 유형으로의 암시적 변환 외에도 대상 유형이 정확히 하나의 적절한 팩토리 메소드 또는 팩토리 생성자를 선언하는 경우 문자열에서 지정된 대상 유형으로 자동 변환하는 폴백 메커니즘을 제공한다.
* 팩토리 메소드: 단일 String 인수를 허용하고 대상 유형의 인스턴스를 리턴하는 대상 유형으로 선언된 private이 아닌 static 메소드. 메소드의 이름은 임의적일 수 있으며 특정 규칙을 따를 필요가 없다.
* 팩토리 생성자: 단일 String 인수를 허용하는 대상 유형의 private이 아닌 constructor. 대상 유형은 최상위 클래스 또는 정적 중첩 클래스로 선언되어야 한다.

###### Explicit Conversion(명시적 변환)

* 암시적 인수 변환에 의존하는 대신 @ConverWith를 사용하여 특정 매개 변수에 사용할 ArgumentConverter를 명시적으로 지정할 수 있다.
* ArgumentConverter의 구현은 최상위 클래스 또는 정적 중첩 클래스로 선언되어야 한다.

##### 2.15.5. Argument Aggregation(인수 집계)

* 기본적으로 @ParameterizedTest에 제공된 각 인수는 단일 메서드 매개 변수에 해당한다.
* 결과적으로 많은 수의 인수를 제공할 것으로 예상되는 인수 소스는 큰 메서드 signatures로 이어질 수 있다.
* 이러한 경우에 다양한 매개 변수 대신에 ArgumentsAccessor를 사용할 수 있다.
* 이 API를 사용하면 테스트 메소드에 전달 된 단일 인수를 통해 제공된 인수에 액세스 할 수 있다.

###### Custom Aggregators

* ArgumentAggregator 인터페이스를 구현하고 호환 가능한 @ParameterizedTest의 메서드에  @AggregateWith 어노테이션을 달아 등록하면 된다.

##### 2.15.6. Customizing Display Names

* name 속성을 통해 지정할 수 있다.

##### 2.15.7. Lifecycle and Interoperability(생명주기 및 상호 운용성)

* 매개 변수화된 테스트의 각 호출은 일반 @Test와 동일한 생명주기를 갖는다.
* 동일한 테스트 클래스 내에서 @Test 메서드와 @ParameterizedTest 메서드를 혼합하여 사용할 수 있다.

#### 2.16. Test Templates

* 해당 메서드가 공급자에 의해 여러 번 호출될 수 있도록 설계되었다.

#### 2.17. Dynamic Tests

* JUnit Jupiter의 표준 @Test는 JUnit 4의 @ Test와 유사하다. 이 테스트 케이스는 컴파일 타임에 완전히 지정되었다는 점에서 정적이며 런타임 시 발생하는 어떤 동작으로도 동작을 변경할 수 없다.

* Assumptions은 기본적인 형태의 동적 행동을 제공하지만 의도적으로 표현력이 제한적이다.

* JUnit Jupiter에서는 @TestFactory 어노테이션을 사용하여 동적으로 생성되는 테스트를 생성할 수 있다.

* @TestFactory 메소드는 단일 DynamicNode 또는 Stream, Collection, Iterable, Iterator 또는 DynamicNode 인스턴스 배열을 리턴해야 한다.

* @Test 메소드와 마찬가지로 @TestFactory 메소드는 private 또는 static이 아니어야하며 선택적으로 ParameterResolvers가 분석할 매개 변수를 선언할 수 있다.

  > **동적 테스트 생명주기**
  >
  > 동적 테스트의 생명주기는 @Test와 상당히 다르다.
  >
  > 특히 개별 동적 테스트에 대한 생명주기 콜백이 없다.
  >
  > 이는 @BeforeEach 및 @AfterEach 메소드와 해당 확장 콜백이 @TestFactory 메소드에 대해 실행되지만 각 동적 테스트에 대해 실행되지 않음을 의미한다.
  >
  > 다시 말해, 동적 테스트를 위해 람다식 내에서 테스트 인스턴스의 필드에 액세스하는 경우 해당 필드는 동일한 @TestFactory 메서드로 생성된 개별 동적 테스트 실행 사이의 콜백 메서드 또는 확장에 의해 재설정되지 않는다.

#### 2.18. Timeouts

* 테스트의 제한 시간을 설정할 수 있다.

* 테스트 시간은 초뿐만 아니라 나노 시간, 마이크로 시간, 분, 시, 일 등 다양하게 설정이 가능하다.

* 따로 unit을 설정하지 않으면 초로 계산된다.

* unit을 통해 다양한 시간 타입을 설정할 수 있다.

  ```java
  class TimeoutTest {
      @BeforeEach
      @Timeout(5)
      void setUp() {
          // 실행 시간이 5초를 넘어가면 실패
      }
  
      @Test
      @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
      void failsIfExecutionTimeExceeds100Milliseconds() {
          // 실행 시간이 0.1초를 넘어가면 실패
      }
  }
  ```

#### 2.19. Parallel Execution

* 기본적으로 JUnit Jupiter 테스트는 단일 스레드에서 순차적으로 실행된다.
* 필요에 따라 병렬로 실행하도록 설정할 수 있다.



> 이 글은 https://junit.org/junit5/docs/current/user-guide 와 https://sun-22.tistory.com/81?category=371101, https://beomseok95.tistory.com/303 를 바탕으로 작성되었습니다.
