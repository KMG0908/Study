### Merge Sort(병합 정렬)
#### 개념
* 2개 이상의 자료를 오름차순이나 내림차순으로 재배열하는 방식
* 여러 개의 정렬된 자료의 집합을 병합하여 한 개의 정렬된 집합으로 정렬하는 것으로써 부분집합으로 분할(divide) 하고, 
각 부분집합에 대해서 정렬 작업을 완성(conquer) 한 후에 정렬된 부분집합들을 다시 결합(combine) 하는 분할 정복(divide and conquer) 기법을 
사용

#### 병합 정렬 방법의 종류
* 2-way 병합 : 2개의 정렬된 자료의 집합을 결합하여 하나의 집합으로 만드는 병합 방법
* n-way 병합 : n개의 정렬된 자료의 집합을 결합하여 하나의 집합으로 만드는 병합 방법

#### 2-way 병합 정렬
  1. 분할(divide) : 입력 자료를 같은 크기의 부분집합 2개로 분할한다.
  2. 정복(conquer) : 부분집합의 원소들을 정렬한다. 부분집합의 크기가 충분히 작지 않으면 순환 호출을 이용하여 다시 분할 정복 기법을 적용한다.
  3. 결합(combine) : 정렬된 부분집합들을 하나의 집합으로 결합한다.
  4. 1, 2, 3의 과정을 반복 수행하면서 정렬을 완성시킨다.
  
#### 코드
```java
public class MergeSort {
    private static int[] sorted;
  
    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            final int middle = (begin + end) / 2;
            mergeSort(arr, begin, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }

    private static void merge(int[] arr, int begin, int middle, int end) {
        int i = begin;
        int j = middle + 1;
        int k = begin;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i++];
            } else {
                sorted[k] = arr[j++];
            }

            k++;
        }

        int t;
        if (i > middle) {
            for (t = j; t <= end; t++, k++) {
                sorted[k] = arr[t];
            }
        } else {
            for (t = i; t <= middle; t++, k++) {
                sorted[k] = arr[t];
            }
        }

        for (t = begin; t <= end; t++) {
            arr[t] = sorted[t];
        }
    }
}
```

#### 특징
* 장점
  * 안정적인 정렬 방법
    * 데이터의 분포에 영향을 덜 받는다. 즉, 입력 데이터가 무엇이든 간에 정렬되는 시간은 동일하다. (O(nlog₂n)로 동일)
  * 만약 레코드를 연결 리스트(Linked List)로 구성하면, 링크 인덱스만 변경되므로 데이터의 이동은 무시할 수 있을 정도로 작아진다.
    * 제자리 정렬(in-place sorting)로 구현할 수 있다.
  * 따라서 크기가 큰 레코드를 정렬할 경우에 연결 리스트를 사용한다면, 합병 정렬은 퀵 정렬을 포함한 다른 어떤 졍렬 방법보다 효율적이다.
* 단점
  * 만약 레코드를 배열(Array)로 구성하면, 임시 배열이 필요하다.
    * 제자리 정렬(in-place sorting)이 아니다.
  * 레코드들의 크기가 큰 경우에는 이동 횟수가 많으므로 매우 큰 시간적 낭비를 초래한다.
    
#### 시간 복잡도
* 분할 단계
  * 비교 연산과 이동 연산이 수행되지 않는다.
* 합병 단계
  * 비교 횟수
    ![비교 횟수](https://gmlwjd9405.github.io/images/algorithm-merge-sort/sort-time-complexity-etc.png)
    * 순환 호출의 깊이 (합병 단계의 수)
      * 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2<sup>k</sup>)했을 때, n=2<sup>3</sup>의 경우, 2<sup>3</sup> -> 2<sup>2</sup> -> 2<sup>1</sup> -> 2<sup>0</sup> 순으로 줄어들어 순환 호출의 깊이가 3임을 알 수 있다. 이것을 일반화하면 n=2<sup>k</sup>의 경우, k(k=log₂n)임을 알 수 있다.
      * k=log₂n
    * 각 합병 단계의 비교 연산
      * 크기 1인 부분 배열 2개를 합병하는 데는 최대 2번의 비교 연산이 필요하고, 부분 배열의 쌍이 4개이므로 24=8번의 비교 연산이 필요하다. 다음 단계에서는 크기 2인 부분 배열 2개를 합병하는 데 최대 4번의 비교 연산이 필요하고, 부분 배열의 쌍이 2개이므로 42=8번의 비교 연산이 필요하다. 마지막 단계에서는 크기 4인 부분 배열 2개를 합병하는 데는 최대 8번의 비교 연산이 필요하고, 부분 배열의 쌍이 1개이므로 8*1=8번의 비교 연산이 필요하다. 이것을 일반화하면 하나의 합병 단계에서는 최대 n번의 비교 연산을 수행함을 알 수 있다.
      * 최대 n번
    * 순환 호출의 깊이 만큼의 합병 단계 * 각 합병 단계의 비교 연산 = **nlog₂n**
  * 이동 횟수
    * 순환 호출의 깊이 (합병 단계의 수)
      * k=log₂n
    * 각 합병 단계의 이동 연산
      * 임시 배열에 복사했다가 다시 가져와야 되므로 이동 연산은 총 부분 배열에 들어 있는 요소의 개수가 n인 경우, 레코드의 이동이 2n번 발생한다.
    * 순환 호출의 깊이 만큼의 합병 단계 * 각 합병 단계의 이동 연산 = **2nlog₂n**
* T(n) = nlog₂n(비교) + 2nlog₂n(이동) = 3nlog₂n = **O(nlog₂n)**


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html 를 바탕으로 작성되었습니다.
