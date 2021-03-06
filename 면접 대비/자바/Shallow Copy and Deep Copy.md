## 얕은 복사와 깊은 복사
### 얕은 복사
* 객체를 복사할 때, 해당 객체만 복사하여 새 객체를 생성한다.
* 복사된 객체의 인스턴스 변수는 원본 객체의 인스턴스 변수와 같은 메모리 주소를 참조한다.
* 따라서, 해당 메모리 주소의 값이 변경되면 원본 객체 및 복사 객체의 인스턴스 변수 값은 같이 변경된다.
```java
ArrayList<Integer> origin = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

ArrayList<Integer> copy = new ArrayList<>();

copy = origin;
```

### 깊은 복사
* 객체를 복사 할 때, 해당 객체와 인스턴스 변수까지 복사하는 방식.
* 전부를 복사하여 새 주소에 담기 때문에 참조를 공유하지 않는다.
```java
ArrayList<Integer> origin = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

ArrayList<Integer> copy = new ArrayList<>();

copy.addAll(list);
```

> 이 글은 https://gwbb.tistory.com/16 를 바탕으로 작성되었습니다.
