## 싱글톤(singleton)
### 개념
* 애플리케이션이 시작될 때 어떤 클래스가 최초 한번만 메모리를 할당하고(static) 그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴
* 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다. 
``` java
public class Printer {
    private static Printer printer = null;
    
    private Printer(){}
    
    public static Printer getInstance() {
        if(printer == null) {
            printer = new Printer();
        }
        
        return printer;
    }
    
    public void print(String input) {
        System.out.println(input);
    }
}
```
* 위와 같은 방식은 생성자를 private로 선언해서 생성이 불가능하게 하고 getInstance를 통해서만 생성이 가능하게 한다.
getInstance는 내부적으로 생성되지 않았다면 생성하고, 기존에 생성된 값이 존재한다면 생성된 인스턴스를 리턴하는 형태로 프로그램 전반에 걸쳐 하나의 인스턴스를 유지한다.

### 장점
* 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있다.
* 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
* DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용한다.  
  ex) 쓰레드풀, 캐시, 대화상자, 사용자 설정, 레지스트리 설정, 로그 기록 객체 등

### 문제점
* 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스의 인스턴스들 간에 결합도가 높아져 "개방-폐쇄 원칙" 을 위배하게 된다.  
  (=객체 지향 설계 원칙에 어긋남)
* Multi-Thread 환경에서 안전하지 않다.

> 이 글은 https://jeong-pro.tistory.com/86 와 https://velog.io/@kyle/%EC%9E%90%EB%B0%94-%EC%8B%B1%EA%B8%80%ED%86%A4-%ED%8C%A8%ED%84%B4-Singleton-Pattern 를 바탕으로 작성되었습니다.
