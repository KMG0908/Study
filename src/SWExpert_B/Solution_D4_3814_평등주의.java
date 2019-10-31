package SWExpert_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://blackbbean.tistory.com/61
// https://computer-choco.tistory.com/176
public class Solution_D4_3814_평등주의 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] numbers = new int[n];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for(int i=0; i<n-1; i++) {
				max = Math.max(max, Math.abs(numbers[i] - numbers[i + 1]));
			}
			
			int start = 0;
			int end = max;
			int middle = (start + end) / 2;
			int last_middle = 0;
			
			while(start <= end) {
				int[] copy = new int[n];
				System.arraycopy(numbers, 0, copy, 0, n);
				
				int temp = k;
				middle = (start + end) / 2;
				
				for(int i=0; i<n-1; i++) {
					if(copy[i+1] - copy[i] > middle) {
						temp -= copy[i+1] - copy[i] - middle;
						copy[i+1] -= copy[i+1] - copy[i] - middle;
					}
					
					if(temp < 0) break;
				}
				
				for(int i=n-1; i>0; i--) {
					if(copy[i-1] - copy[i] > middle) {
						temp -= copy[i-1] - copy[i] - middle;
						copy[i-1] -= copy[i-1] - copy[i] - middle;
					}
					
					if(temp < 0) break;
				}
				
				if(temp < 0) {
					start = middle + 1;
				}
				else {
					end = middle - 1;
					last_middle = middle;
				}
			}
			
			System.out.println("#" + t + " " + last_middle);
		}
	}
}
