### Quick Sort(퀵 정렬)
#### 개념
* 정렬할 전체 원소에 대해서 정렬을 수행하지 않고, **기준 값**을 중심으로 **왼쪽 부분 집합**과 **오른쪽 부분 집합**으로 **분할**하여 정렬하는 방식
* 과정
  1. 왼쪽 부분 집합에는 기준 값보다 작은 원소들을 이동시키고, 오른쪽 부분 집합에는 기준 값보다 큰 원소들을 이동시킨다.
  2. 기준 값 : 피봇 (`pivot`), 일반적으로 전체 원소 중에서 가운데에 위치한 원소를 선택한다.
  3. 분할(divide) : 정렬할 자료들을 기준 값을 중심으로 2개의 부분 집합으로 분할한다.
  4. 정복(conquer) : 부분집합의 원소들 중에서 기준 값보다 작은 원소들은 왼쪽 부분집합으로, 기준 값보다 큰 원소들은 오른쪽 부분집합으로 정렬한다. 부분집합의 크기가 1이하로 충분히 작지 않으면 순환 호출을 이용하여 다시 분할한다.
  
#### 코드
```java
public class QuickSort {
    public static void sort(int[] arr, int begin, int end) {
        if(begin < end) {
            int pivot = partition(arr, begin, end);
            quickSort(arr, begin, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }
	
    public static int partition(int[] arr, int begin, int end) {
        int pivot = (begin+end)/2;
        int left = begin;
        int right = end;
		
        do {
            while (arr[left] < arr[pivot] && left < right)
                left++;
            while (arr[right] >= arr[pivot] && left < right)
                right--;
            if (left < right) { // L과 R이 다른 곳에서 멈췄을 경우
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } 
        } while (left < right);
		
        // L과 R이 만났을 경우
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
		
        return right;
    }
}
```

#### 특징
* 장점
  * 속도가 빠르다.
    * 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
  * 추가 메모리 공간을 필요로 하지 않는다.
    * 퀵 정렬은 O(log n)만큼의 메모리를 필요로 한다.
* 단점
  * 정렬된 리스트에 대해서는 퀵 정렬의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
* 퀵 정렬의 불균형 분할을 방지하기 위하여 피봇을 선택할 때 더욱 리스트를 균등하게 분할할 수 있는 데이터를 선택한다.
  * EX) 리스트 내의 몇 개의 데이터 중에서 크기순으로 중간 값(medium)을 피봇으로 선택한다.
    
#### 시간 복잡도
##### 최선의 경우
![최선](https://gmlwjd9405.github.io/images/algorithm-quick-sort/sort-time-complexity-etc1.png)
* 비교 횟수
  * 순환 호출의 깊이
    * 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2<sup>k</sup>)했을 때, n=2<sup>3</sup>의 경우, 
    2<sup>3</sup> -> 2<sup>2</sup> -> 2<sup>1</sup> -> 2^0 순으로 줄어들어 순환 호출의 깊이가 3임을 알 수 있다. 
    이것을 일반화하면 n=2<sup>k</sup>의 경우, k(k=log₂n)임을 알 수 있다.
    * k=log₂n
  * 각 순환 호출 단계의 비교 연산
    * 각 순환 호출에서는 전체 리스트의 대부분의 레코드를 비교해야 하므로 평균 n번 정도의 비교가 이루어진다.
    * 평균 n번
    * 순환 호출의 깊이 * 각 순환 호출 단계의 비교 연산 = nlog₂n
* 이동 횟수
  * 비교 횟수보다 적으므로 무시할 수 있다.
* 최선의 경우 T(n) = **O(nlog₂n)**
##### 최악의 경우
![최악](https://gmlwjd9405.github.io/images/algorithm-quick-sort/sort-time-complexity-etc2.png)
* 리스트가 계속 불균형하게 나누어지는 경우 (특히, 이미 정렬된 리스트에 대하여 퀵 정렬을 실행하는 경우)
* 비교 횟수
  * 순환 호출의 깊이
    * 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2<sup>k</sup>)했을 때, 순환 호출의 깊이는 n임을 알 수 있다.
    * n
  * 각 순환 호출 단계의 비교 연산
    * 각 순환 호출에서는 전체 리스트의 대부분의 레코드를 비교해야 하므로 평균 n번 정도의 비교가 이루어진다.
    * 평균 n번
  * 순환 호출의 깊이 * 각 순환 호출 단계의 비교 연산 = n<sup>2</sup>
* 이동 횟수
  * 비교 횟수보다 적으므로 무시할 수 있다.
* 최악의 경우 T(n) = **O(n<sup>2</sup>)**
##### 평균
* 평균 T(n) = **O(nlog₂n)**
* 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
* 퀵 정렬이 불필요한 데이터의 이동을 줄이고 먼 거리의 데이터를 교환할 뿐만 아니라, 한 번 결정된 피봇들이 추후 연산에서 제외되는 특성 때문이다.


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html 를 바탕으로 작성되었습니다.
