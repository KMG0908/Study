package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] time = new int[n];
			
			int max = 0;
			
			for(int i=0; i<n; i++) {
				time[i] = Integer.parseInt(br.readLine());
				max = Math.max(max, time[i]);
			}
			
			long left = 0;
			long right = max * (long)m;
			long mid = 0;
			
			while(left <= right) {
				mid = (left + right) / 2;
				
				long res = 0;
				
				for(int i=0; i<n; i++) {
					res += mid / time[i];
				}
				
				if(res < m) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			
			System.out.println("#" + t + " " + left);
		}
	}
}
