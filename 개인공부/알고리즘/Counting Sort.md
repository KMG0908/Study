### Counting Sort(계수 정렬)
#### 개념
* 원소간 비교하지 않고 각 원소가 몇개 등장하는지 갯수를 세서 정렬하는 방식
* 카운팅 정렬을 사용하는 대표적인 경우가 접미사 배열 (Suffix Array) 을 얻는 경우이다.
  * 일반적인 정렬을 사용한 접미사 배열은 O(N<sup>2</sup>logn) 의 시간 복잡도가 걸리지만, 카운팅 정렬를 사용할 경우, O(nlogn) 의 시간복잡도를 가지고 얻는 것이 가능하다.
* 과정
  1. 각 숫자가 몇번 등장하는지 세어준다.
  2. 등장 횟수를 누적합으로 바꿔준다.
  3. 정렬할 배열 A를 뒤에서 앞으로 순회하면서(2번 과정의 누적합 이용) 정렬된 배열 B에 넣어준다.

#### 코드
```java
public class CountingSort {
    public static void sort(int[] number) {
        int length = number.length;
    
        int[] result = new int[length];
        int[] count = new int[10];
		
        // 1. count 세기
        for(int i=0; i<length; i++) {
            count[number[i]]++;
        }
		
        // 2. 누적 count로 변경
        for(int i=1; i<10; i++) {
            count[i] = count[i-1] + count[i];
        }
		
        // 3. 입력받은 원소를 누적 count를 이용해서 자기자리 찾아넣기
        for(int i=length-1; i>=0; i--) {
            result[count[number[i]]-1] = number[i];
            count[number[i]]--;
        }
    }
}
```

#### 특징
* 장점
  * 안정 정렬이다.  
    * 안정 정렬: 동일한 값을 가지는 다수의 요소들이 정렬 후에도 정렬 전과 같은 순서를 가지는 것이다.
    * 누적 합을 기반으로 출력 배열에 요소를 이동하며 정렬할 때, 입력 배열의 가장 큰 인덱스에서 작은 인덱스로 진행해야 안정 정렬이 가능하다 (오른쪽에서 왼쪽).
* 단점
  * 누적합 배열에 대한 접근을 O(1)에 달성하기 위해 정렬할 배열에 포함된 숫자의 최댓값 만큼의 메모리를 필요로 한다.
    * 0, 2, 0, 100, 20 배열을 Counting Sort 알고리즘으로 정렬하기 위해서는 누적합 배열의 길이를 100으로 잡아야 한다.  
      → 따라서, 정렬하는 숫자가 특정한 범위(코드 예시 : 0~9) 안에 있을 때 사용하게 된다. 
    
#### 시간 복잡도
* T(n) = **O(n)**


> 본 글은 https://soobarkbar.tistory.com/101 과 https://bowbowbow.tistory.com/8 를 바탕으로 작성되었습니다.
