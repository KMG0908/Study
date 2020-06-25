## final
### 1. final 변수
#### 1.1 원시 타입
로컬 원시 변수에 final로 선언하면 한번 초기화된 변수는 변경할 수 없는 상수값이 된다.
```java
public void test_final_primitive_variables() {
    final int x = 1;
    //x = 3; //한번 할당되면 변경할 수 없음.
}
```
#### 1.2 객체 타입
객체 변수에 final로 선언하면 그 변수에 다른 참조 값을 지정할 수 없다. 원시 타입과 동일하게 한번 쓰여진 변수는 변경할 수 없다. 
단, 객체 자체가 immutable하다는 의미는 아니다. 객체의 **속성**은 **변경 가능**하다. 
```java
public void test_final_reference_variables() {
    final Pet pet = new Pet();
    // pet = new Pet(); //다른 객체로 변경할수 없음

    pet.setWeight(3); //객체 필드는 변경할 수 있음
}
```
#### 1.3 메서드 인자
메서드 인자에 final 키워드를 붙이면, 메서드 안에서 변수값을 변경할 수 없다. 
``` java
public class Pet {
    int weight;
    public void setWeight(final int weight) {
        // weight = 1; //final 인자는 메서드안에서 변경할 수 없음
    }
}
```
#### 1.4 멤버 변수
클래스의 맴버 변수에 final로 선언하면 상수값이 되거나 write-once 필드로 한 번만 쓰이게 된다. 
final로 선언하면 초기화되는 시점은 생성자 메서드가 끝나기 전에 초기화가 된다. 하지만, static이냐 아니냐에 따라서도 초기화 시점이 달라진다.
* static final 맴버 변수 (static final int x = 1)
  * 값과 함께 선언시 
  * 정적 초기화 블록에서 (static initialization block)
* instance final 맴버 변수 (final int x = 1)
  * 값과 함께 선언시 
  * 인스턴스 초기화 블록에서 (instance initialization block)
  * 생성자 메서드에서
  
### 2. final 메서드
메서드를 final로 선언하면 상속받은 클래스에서 오버라이드가 불가능하게 된다. Dog 객체는 Pet의 makeSound() 메서드를 재정의할 수 없다. 
언제 사용하면 좋을까? 구현한 코드의 변경을 원하지 않을 때 사용한다. side-effect가 있으면 안 되는 자바 코어 라이브러리에서 final로 선언된 부분을 많이 찾을 수 있다.
``` java
public class Pet {
    public final void makeSound() {
        System.out.println("ahaha");
    }
}

public class Dog extends Pet {
    // final로된 메서드는 override할수 없음
    public void makeSound() { 

    }
}
```

### 3. final 클래스
클래스에 final을 선언하면 상속 자체가 안된다. 그냥 클래스 그대로 사용해야 한다. Util 형식의 클래스나 여러 상수 값을 모아둔 Constants 클래스을 final로 선언한다. 
``` java
public final class Pet {

}

//Pet 클래스가 final 클래스로 선언되어 상속할 수 없음
public class Dog extends Pet {

}
```
#### 3.1 상수 클래스
상수 값을 모아준 클래스는 굳이 상속해서 쓸 이유는 없다.
``` java
public final class Constants {
    public static final int SIZE = 10;
}

//public class SubConstants extends Constants {
//}
```
#### 3.2 Util 형식의 클래스
JDK에서 String도 final 클래스로 선언되어 있다. 자바의 코어 라이브러리이기 때문에 side-effect가 있으면 안 된다. 
다른 개발자가 상속을 해서 새로운 SubString을 만들어 라이브러리로 다른 곳에서 사용하게 되면 유지보수, 정상 실행 보장이 어려워질 수 있다.
``` java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
}
```

> 이 글은 https://advenoh.tistory.com/13 를 바탕으로 작성되었습니다.
