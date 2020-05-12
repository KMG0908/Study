package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	public static int n, arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int max = 0;
		
		do {
			int sum = 0;
			
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(arr[i] - arr[i + 1]);
			}
			
			max = Math.max(max, sum);
		} while(nextPermutation());
		
		System.out.println(max);
	}
	
	public static boolean nextPermutation() {
		int i = n - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		
		if(i==0) return false;
		
		int j = n - 1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1, j);
		
		j = n - 1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
