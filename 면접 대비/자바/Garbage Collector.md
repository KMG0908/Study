## 가비지 컬렉터(Garbage Collector)
### 개념
* Java 프로세스가 동작하는 과정에서 GC는 불필요한 또는 더이상은 사용하지 않는 객체들을 메모리에서 제거함으로써, Java 프로세스가 한정된 메모리를 효율적으로 사용할 수 있게 해준다.
* JVM에서 GC의 스케줄링을 담당함으로서 Java 프로그래머들에게는 메모리를 관리해야하는 부담을 줄여주게 된다. 
즉, 일반적인 개발 작업간에는 메모리 할당/해제를 직접 프로그래밍하지 않아도 된다는 이야기다.

### JVM 구조
![구조](https://mirinae312.github.io/img/jvm_gc/JVMHeap.png)

### GC 동작 과정
![동작 과정](https://mirinae312.github.io/img/jvm_gc/JVMObjectLifecycle.png)
> Minor GC: Young Generation 영역에서 발생하는 GC  
> Full GC: Young Generation, Old Generation 전체 영역에 대한 GC 
``` java
Model model = new Model("value");
doSomething(model);  

// 더이상 model 을 사용하지 않음
```
**처음 생성된 객체** new Model(); 는 **Young Generation 영역의 일부**인 **Eden** 영역에 위치하게된다. 
그리고 Minor GC가 발생하게 되면, 사용하지 않는 다시말하면 다른 곳에서 참조되지 않는 객체는 메모리에서 제거된다.  
**Eden 영역에서 살아남은 객체**는 **Young Generation 영역의 또다른 일부**인 **Survivor** 영역으로 이동하게된다. 
Survivor 영역은 Survivor1 영역과 Survivor2 영역으로 구성되어 있는데, 
Minor GC가 발생할 때마다 Survivor1 영역에서 Survivor2 영역으로 또는 Survivor2 영역에서 Survivor1 영역으로 객체가 이동하게 되며,
이 과정에서 더이상 참조되지 않는 객체는 메모리에서 제거된다.  
Minor GC가 발생하는 동안 Survivor1, Survivor2 영역을 오가며 살아남은 객체들은 최종적으로 Old Generation 영역으로 옮겨지며,
Old Generation 영역에 있다가 미사용된다고 식별되는 객체들은 Full GC를 통해 메모리에서 제거된다. 

> 이 글은 https://mirinae312.github.io/develop/2018/06/04/jvm_gc.html 를 바탕으로 작성되었습니다.
