## Java 8 변경 사항
### 1. 람다 표현식(Lambda Expression)
#### 개념
* 익명 클래스의 한 개의 메소드를 식으로 표현한 것
  * 익명 클래스: 름이 없는 클래스로써, 단 한 개의 객체만을 생성할 수 있는 일회용 클래스
* 람다 표현식을 사용하면 기존의 불필요한 코드를 줄여주고, 작성된 코드의 가독성을 높여준다.
* Java SE 8부터는 이러한 람다 표현식을 사용하여 자바에서도 함수형 프로그래밍을 할 수 있게 되었다.

#### 작성법
``` (매개변수 목록) -> {함수 몸체}```
* 주의점
1. 매개변수가 한 개인 경우 ()를 생략할 수 있다.
2. 함수 몸체가 한 개의 명령문으로만 이루어진 경우에는 {}를 생략할 수 있다.
3. 함수 몸체가 한 개의 return 문으로만 이루어진 경우에는 {}를 생략할 수 없다.
``` java
new Thread(new Runnable() {
    public void run() {
        System.out.println("전통적인 방식의 스레드 생성");
    }
}).start();
 
 
new Thread(()->{
    System.out.println("람다 표현식을 사용한 스레드 생성");
}).start();
```

#### 함수형 인터페이스
* 추상 클래스와 달리 단 한 개의 추상 메소드만을 가져야한다.
* `@FunctionalInterface`를 사용하여 함수형 인터페이스임을 명시할 수 있습니다.
``` java
// 함수형 인터페이스 구현
@FunctionalInterface
interface ExampleInterfac{
    public int doSomething(int x, int y);
}
 
public class test {
    public static void main(String[] args) {
        ExampleInterface implemented = (x, y) -> x + y;		// 추상 메소드 구현
        System.out.println(implemented.doSomething(10, 11));	// 21을 출력함
    }
}
```

### 2. 스트림 API(Stream API)
#### 개념
* 데이터를 추상화해서 다루므로, 다양한 형태로 저장된 데이터를 위한 공통된 방법을 제공

#### 특징
1. 스트림은 외부 반복을 통해 작업하는 컬렉션과는 다르게 내부 반복을 통해 작업을 수행한다.
2. 스트림은 단 한번만 사용할 수 있다. (= 재사용이 불가능하다.)
3. 스트림은 원본 데이터를 변경하지 않는다.
4. 스트림의 연산은 필터-맵(filter-map) 기반의 API를 사용하여 lazy 연산을 통해 성능을 최적화한다.
5. 스트림은 parallelStream() 메소드를 통해 간단한 병렬처리를 지원한다.
``` java
// 정수형 배열에서 스트림 생성
Integer[] arr1 = new Integer[] {1, 5, 11, 13, 20, 52};
Stream stream1 = Arrays.stream(arr1);
stream1.map(i -> i * 2);
stream1.filter(i -> i % 2 == 0);			// 재사용이 불가능하기 때문에 에러 발생!
 
// 정수형 배열에서 스트림 생성
Integer[] arr2 = new Integer[] {1, 5, 11, 13, 20, 52};
Stream stream2;
stream2 = Arrays.stream(arr2)
            .filter(i -> i % 2 != 0)	// {1, 5, 11, 13}
            .map(i -> i * 2);			// {2, 10, 22, 26}
```

### 3. java.time 패키지
#### Calendar 클래스의 문제점
1. Calendar 인스턴스는 immutable object가 아니라서 값이 수정될 수 있다.
2. 윤초(leap second)와 같은 특별한 상황을 고려하지 않는다.
3. Calendar 클래스에서는 월(month)을 나타낼 때 1~12가 아닌 0~11로 표현해야 한다.  
=> Java SE 8 버전에서는 위 문제점을 모두 해결한 java.time 패키지를 제공한다.
``` java
LocalDate today = LocalDate.now();
System.out.println("올해는" + today.getYear() + "년입니다.");
 
LocalDate otherDay = today.withYear(1982);
System.out.println("올해는" + otherDay.getYear() + "년입니다.");
```

### 4. 나즈혼 (Nashorn)
지금까지 자바스크립트의 기본 엔진으로는 모질라의 라이노 (Rhino)가 사용되어 왔다. 
하지만 세월이 흐르면서 자바의 최신 개선 사항 등을 제대로 활용하지 못하는 등 노후화 된 모습을 보여주게 된다.
따라서 Java SE 8 버전부터는 자바스크립트의 새로운 엔진으로 오라클의 **나즈혼(Nashorn)**을 도입하게 된다. 
나즈혼은 기존에 사용되어 온 라이노에 비해 성능과 메모리 관리 측면에서 크게 개선된 스크립트 엔진이다.

> 이 글은 https://empty-cloud.tistory.com/76 를 바탕으로 작성되었습니다.
