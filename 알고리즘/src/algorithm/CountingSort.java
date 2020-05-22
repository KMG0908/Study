package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] number = new int[N];
		int[] result = new int[N];
		int[] count = new int[10];
		
		// 1. count 세기
		for(int i=0; i<N; i++) {
			number[i] = sc.nextInt();
			count[number[i]]++;
		}
		
		// 2. 누적 count로 변경
		for(int i=1; i<10; i++) {
			count[i] = count[i-1] + count[i];
		}
		
		// 3. 입력받은 원소를 누적 count를 이용해서 자기자리 찾아넣기
		for(int i=N-1; i>=0; i--) {
			result[count[number[i]]-1] = number[i];
			count[number[i]]--;
		}
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(result));
	}
}
