### Radix Sort(기수 정렬)
#### 개념
* 원소의 키값을 나타내는 기수를 이용한 정렬 방식
* 정렬할 원소의 키값에 해당하는 버킷(bucket)에 원소를 분배하였다가 버킷의 순서대로 원소는 꺼내는 방법을 반복하면서 정렬한다.  
* 원소의 키를 표현하는 기수만큼의 버킷을 사용. ex) 10진수로 표현된 키값을 가진 원소들을 정렬할 때에는 0부터 9까지의 10개의 버킷 사용
* 과정
  1. 키값의 일의 자리에 대해서 기수 정렬을 수행한다.
  2. 다음 단계에서는 키값의 십의 자리에 대해서 정렬을 수행한다.
  3. 그리고 그다음 단계에서는 백의 자리에 대해서 정렬을 수행한다.
  4. 1, 2, 3에서 진행되었던 것처럼 자릿수만큼 반복하여 정렬을 수행한다.
  
#### 코드
```java
public class RadixSort {
    @SuppressWarnings("unchecked")
    private static LinkedList<Integer>[] counter = new LinkedList[] {
            new LinkedList<>(), new LinkedList<>(),
            new LinkedList<>(), new LinkedList<>(),
            new LinkedList<>(), new LinkedList<>(),
            new LinkedList<>(), new LinkedList<>(),
            new LinkedList<>(), new LinkedList<>() };

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }

        final int maxDigit = String.valueOf(max).length();
        radixSort(arr, maxDigit);
    }

    private static void radixSort(int[] arr, int digitCount) {
        int mod = 10;
        int div = 1;

        for (int i = 0; i < digitCount; i++, div *= 10, mod *= 10) {
            for (final int element : arr) {
                final int bucket = element % mod / div;
                counter[bucket].add(element);
            }

            int pos = 0;
            for (final LinkedList<Integer> element : counter) {
                Integer value;
                while ((value = element.poll()) != null) {
                    arr[pos++] = value;
                }
            }
        }
    }
}
```

#### 특징
* 장점
  * 안정 정렬이다.
* 단점
  * counter과 bucket처럼 추가적인 메모리가 필요하다.
    
#### 시간 복잡도
* T(n) = **O(kn)** (k는 가장 큰 데이터의 자리수) 


> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e 과 https://www.zerocho.com/category/Algorithm/post/58007c338475ed00152d6c4c 를 바탕으로 작성되었습니다.
