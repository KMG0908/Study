### Selection Sort(선택 정렬)
#### 개념
* 전체 원소들 중에서 **기준 위치에 맞는 원소**를 **선택**하여 자리를 교환하는 방식
* 과정
  1. 전체 원소 중에서 가장 작은 원소를 찾아 선택하여 첫 번째 원소와 자리를 교환한다.
  2. 두 번째로 작은 원소를 찾아서 선택하여 두 번째 원소와 자리를 교환한다.
  3. 세 번째로 작은 원소를 찾아 선택하여 세 번째 원소와 자리를 교환한다.
  4. 이 과정을 반복하면서 정렬이 완성된다.
  
#### 코드
```java
public class SelectionSort {
    public static void sort(int[] number) {
        int length = number.length, temp = 0;
		
        for (int i=0; i<length; i++) {
            int min = i;

            // 최솟값 탐색
            for (int j=i+1; j<length; j++) {
                if (number[j] < number[min]) {
                    min = j;
                }
            }

            // 최솟값이 자신이면 자리 이동을 할 필요가 없음
            if (min == i) {
                continue;
            }
            
            temp = number[min];
            number[min] = number[i];
            number[i] = temp;
        }
    }
}
```

#### 특징
* 장점
  * 정렬을 위한 비교 횟수는 많으나 교환 횟수는 상당히 적다.  
    → 교환이 많이 이루어져야하는 자료 상태에서 가장 효율적이다.
* 단점
  * 안전성을 만족하지 않는다.  
    → 값이 같은 레코드가 있는 경우에 상대적인 위치가 변경될 수 있다.
    
#### 시간 복잡도
* 비교 횟수
  * 두 개의 for 루프의 실행 횟수
  * 외부 루프: (n-1)번
  * 내부 루프(최솟값 찾기): n-1, n-2, … , 2, 1 번
* 교환 횟수
  * 외부 루프의 실행 횟수와 동일. 즉, 상수 시간 작업
  * 한 번 교환하기 위하여 3번의 이동이 필요하므로 3(n-1)번
* T(n) = (n-1) + (n-2) + … + 2 + 1 = n(n-1)/2 = O(n²)


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html 를 바탕으로 작성되었습니다.
