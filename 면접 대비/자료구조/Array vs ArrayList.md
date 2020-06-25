## 배열(Array)와 리스트(ArrayList)의 차이점
### 1. 배열은 크기가 고정되어있지만 ArrayList 사이즈가 동적인 배열이다.
### 2. 배열은 primitive type(int, byte, char 등)과 object 모두를 담을 수 있지만, ArrayList object element만 담을 수 있다.
### 3. 배열은 제네릭을 사용할 수 없지만, ArrayList 타입 안정성을 보장해주는 제네릭을 사용할 수 있다.
### 4. 길이에 대해 배열은 length 변수를 쓰고, ArrayList size() 메서드를 써야한다.
### 5. 배열은 element들을 할당하기 위해 assignment(할당) 연산자를 써야하고, ArrayList add() 메서드를 통해 element를 삽입한다.
### 6. 배열은 초기화시 메모리에 할당되어 ArrayList에 비해 속도가 빠르고, ArrayList는 추가/삭제시 메모리를 재할당하기 때문에 배열에 비해 속도가 느리다.
### 7. 배열은 다차원이 가능하지만 ArrayList는 불가능하다.

> 이 글은 https://zorba91.tistory.com/287 와 https://blog.naver.com/PostView.nhn?blogId=sangrime&logNo=220622445166 를 바탕으로 작성되었습니다.
