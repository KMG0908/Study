### Shell Sort(셸 정렬)
#### 개념
* 일정한 간격(interval)으로 떨어져 있는 자료들끼리 부분집합을 구성하고 각 부분집합에 있는 원소들에 대해서
삽입 정렬을 수행하는 작업을 반복하면서 전체 원소들을 정렬하는 방법이다. 전체 원소에 대해서 삽입 정렬을 수행하는 것보다
부분집합으로 나누어 정렬하게 되면 비교 연산과 교환 연산이 감소할 수 있는 점에서 착안된 방식
* 과정
  1. 부분집합의 기준이 되는 간격을 변수 interval에 저장한다.
  2. 한 단계가 수행될 때마다 interval의 값을 감소시키고 쉘 정렬을 순환 호출한다.
  3. interval가 1이 될 때까지 반복한다.  
* 쉘 정렬의 성능은 interval의 값에 따라 달라진다. 
   정렬할 자료의 특성에 따라 interval 생성 함수를 사용하고 일반적으로 사용하는 interval의 값은 
   원소 개수의 1/2을 사용하고 한 단계 수행될 때마다 interval의 값을 반으로 감소시키면서 반복 수행한다.
  
#### 코드
```java
public class ShellSort {
    public static void shellSort(int[] arr) {
        final int length = arr.length;
        int interval = length / 2;

        while (interval >= 1) {
            for (int i = 0; i < length; i++) {
                intervalSort(arr, i, length - 1, interval);
            }

            interval /= 2;
        }
    }

    private static void intervalSort(int[] arr, int begin, int end, int interval) {
        for (int i = begin + interval; i <= end; i += interval) {
            final int key = arr[i];
            int position = i;

            while (position >= interval && key < arr[position - interval]) {
                arr[position] = arr[position - interval];
                position -= interval;
            }

            arr[position] = key;
        }
    }
}
```

#### 특징
* 장점
  * 연속적이지 않은 부분 리스트에서 자료의 교환이 일어나면 **더 큰 거리를 이동한다.** 따라서 교환되는 요소들이 삽입 정렬보다는 최종 위치에 있을 가능성이 높아진다.
  * 부분 리스트는 어느 정도 정렬이 된 상태이기 때문에 부분 리스트의 개수가 1이 되게 되면 셸 정렬은 기본적으로 삽입 정렬을 수행하는 것이지만 **삽입 정렬보다 더욱 빠르게 수행된다.**
  * 알고리즘이 간단하여 프로그램으로 쉽게 구현할 수 있다.
    
#### 시간 복잡도
* 평균: T(n) = **O(n<sup>1.5</sup>)**
* 최악의 경우: T(n) = **O(n<sup>2</sup>)**


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://gmlwjd9405.github.io/2018/05/08/algorithm-shell-sort.html 를 바탕으로 작성되었습니다.
