package algorithm;

import java.util.Arrays;

public class NextPermutation {
	static int N, cnt = 0;
	static int numbers[];
	
	public static void main(String[] args) {
		N = 5;
		numbers = new int[] {1, 2, 3, 4, 5};
		
		do {
			System.out.println(Arrays.toString(numbers));
		} while(nextPermutation());
		
		System.out.println("경우의 수: " + cnt);
	}
	
	public static boolean nextPermutation() {
		cnt++;
		
		// 1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		// 찾은 위치가 0이면 이미 내림차순된 순열이므로 다음 순열은 존재하지 않음
		if(i==0) return false;
		
		// 2. i-1 위치: 교환이 필요한 위치
		//    i-1 위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N - 1;
		while(numbers[i-1] >= numbers[j]) j--;
		
		// 3. i-1 위치값과 j 위치값 교환
		swap(i-1, j);
		
		// 4. i 위치부터 끝까지의 순열을 오름차순으로 재조정
		j = N - 1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
