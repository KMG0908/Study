### 1. 정렬 알고리즘의 종류
* [Selection Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Selection%20Sort.md)
* [Bubble Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Bubble%20Sort.md)
* [Quick Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Quick%20Sort.md)
* [Insertion Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Insertion%20Sort.md)
* [Shell Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Shell%20Sort.md)
* [Merge Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Merge%20Sort.md)
* [Heap Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Heap%20Sort.md)
* [Counting Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Counting%20Sort.md)
* [Radix Sort](https://github.com/KMG0908/Study/blob/master/%EA%B0%9C%EC%9D%B8%EA%B3%B5%EB%B6%80/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Radix%20Sort.md)

### 2. 정렬 알고리즘 분류
#### 1) 실행 방법에 따른 분류
* 비교식 정렬(comparative sort)  
  * 비교하고자 하는 각 키값들을 한 번에 두 개씩 비교하여 교환하는 방식으로 정렬을 실행
  * Selection, Bubble, Quick, Insertion 등
* 분산식 정렬(distribute sort)
  * 키값을 기준으로 하여 자료를 여러 개의 부분 집합으로 분해하고, 각 부분 집합을 정렬함으로써 전체를 정렬하는 방식으로 실행
#### 2) 정렬 장소에 따른 분류
* 내부 정렬(internal sort)
  * 정렬할 자료를 메인 메모리에 올려서 정렬하는 방식
  * 정렬 속도가 빠르지만 정렬할 수 있는 자료의 양이 메인 메모리의 용량에 따라서 제한
  * 교환 방식(Selection, Bubble, Quick), 삽입 방식(Insertion, Shell), 병합 방식(2-way 병합, n-way 병합), 분배 방식(Radix), 선택 방식(Heap, Tree) 등
* 외부 정렬(external sort)
  * 정렬할 자료를 보조 기억장치에서 정렬하는 방식
  * 대용량의 보조 기억 장치를 사용하기 때문에 내부 정렬보다 속도는 떨어지지만 내부 정렬로 처리할 수 없는 대용량의 자료에 대한 정렬이 가능
  * 병합 방식(2-way 병합, n-way 병합)
  
### 3. 알고리즘 성능
* 일반적으로는 Quick Sort가 가장 빠르다. 최악의 경우는 n<sup>2</sup>인데 이는 피봇이 최소값, 최대값으로 잡히게 될 경우이다. 
이를 피하기 위해서 피봇을 랜덤으로 잡거나 Media-Of-Three Partitioning이라는 기법을 사용한다. 평균적으로 가장 좋은 성능을 낸다.
* 이미 정렬되어 있는 자료의 경우에는 Insertion Sort가 제일 빠르다. 이미 정렬되어 있는 경우 바로 앞자리 원소와 한 번만 비교하면 되기 때문이다.
* O(n²) : Bubble Sort, Selection Sort, Insertion Sort, Shell Sort, Quick Sort  
O(n log n) : Heap Sort, Merge Sort  
O(kn) : Radix Sort (k는 자릿수, 자릿수가 적은 4바이트 정수에서나 제대로 된 성능을 낼 수 있다는 제약조건이 있다.) 
O(n) : Counting Sort(Counting Sort는 보통 k=O(n)일 때 사용되기 때문에 시간 복잡도가 O(n)이다. n > k라고 하면 시간 복잡도는 O(n + k)가 된다. 
  
> 본 글은 https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e를 바탕으로 작성되었습니다.
