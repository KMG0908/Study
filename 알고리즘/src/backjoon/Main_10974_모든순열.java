package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10974_모든순열 {
	public static int N, numbers[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		for(int i=0; i<N; i++){
			numbers[i] = i + 1;
		}
		
		do {
			for(int i=0; i<N; i++){
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
		} while(nextPermutation());
		
		System.out.println(sb.toString());
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		if(i==0) return false;
		
		int j = N - 1;
		while(numbers[i-1] >= numbers[j]) j--;
		
		swap(i-1, j);
		
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
