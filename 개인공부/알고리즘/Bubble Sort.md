### Bubble Sort(버블 정렬)
#### 개념
* 인접한 두 개의 원소를 비교하여 자리를 교환하는 방식
* 과정
  1. 첫 번째 원소부터 마지막 원소까지 반복하여 한 단계가 끝나면 가장 큰 원소가 마지막 자리로 정렬(Ascending이냐 Descending이냐에 따라 대소 비교는 다르게 적용하면 된다).
  2. 첫 번째 원소부터 인접한 원소끼리 계속 자리를 교환하면서, 맨 마지막 자 리로 이동하는 모습이 물속에서 물 위로 올라오는 물방울 모양과 같다고 하여 버블(Bubble) 정렬이라고 한다.
  
#### 코드
```java
public class BubbleSort {
    public static void sort(int[] number) {
        int size = number.length, temp = 0;
		
        for(int i=size-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(number[j] > number[j+1]) {
                    temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
            }
        }
    }
}
```

#### 특징
* 장점
  * 구현이 매우 간단하다.
* 단점
  * 순서에 맞지 않은 요소를 인접한 요소와 교환한다.
  * 하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는 배열에서 모든 다른 요소들과 교환되어야 한다.
  * 특히 특정 요소가 최종 정렬 위치에 이미 있는 경우라도 교환되는 일이 일어난다.
    
#### 시간 복잡도
* 비교 횟수
  * 최상, 평균, 최악 모두 일정
  * n-1, n-2, … , 2, 1 번 = n(n-1)/2
* 교환 횟수
  * 입력 자료가 역순으로 정렬되어 있는 최악의 경우, 한 번 교환하기 위하여 3번의 이동이 필요하므로 (비교 횟수 * 3) 번 = 3n(n-1)/2
  * 입력 자료가 이미 정렬되어 있는 최상의 경우, 자료의 이동이 발생하지 않는다.
* T(n) = O(n²)


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html 를 바탕으로 작성되었습니다.
