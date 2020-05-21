package algorithm;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int list[]) {
		final int SIZE = list.length;
		
		for(int i=0; i<SIZE; i++) {	// 정렬되지 않은 집합
			int temp = list[i];		// 정렬되어야 하는 원수
			
			for(int j=0; j<i; j++) {// 정렬된 집합
				if(temp < list[j]) {
					for(int k=i-1; k>=j; k--) {	// 정렬된 집합의 맨 뒤부터 삽입지점까지 뒤로 민다
						list[k+1] = list[k];
					}
					list[j] = temp;	// 삽입지점에 원소 넣기
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int list[] = new int[]{69, 10, 2, 16, 8, 31, 22};
		
		insertionSort(list);
		
		System.out.println(Arrays.toString(list));
	}
}
