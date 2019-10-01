package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6549_히스토그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			int[] rectangle = new int[n];
			
			for(int i=0; i<n; i++) {
				rectangle[i] = Integer.parseInt(st.nextToken());
			}
			
			long max = 0;
			
			for(int i=0; i<n; i++) {
				long size = left(rectangle, i) + right(rectangle, i) - rectangle[i];	// rectangle[i]가 겹치므로 빼주기
				if(size > max) max = size;
			}
			
			System.out.println(max);
		}
	}
	
	public static long left(int[] arr, int index) {
		long width = 1;
		
		for(int i=index-1; i>=0; i--) {
			if(arr[i] >= arr[index]) width++;
			else break;
		}
		
		return width * arr[index];
	}
	
	public static long right(int[] arr, int index) {
		long width = 1;
		
		for(int i=index+1; i<arr.length; i++) {
			if(arr[i] >= arr[index]) width++;
			else break;
		}
		
		return width * arr[index];
	}
}
