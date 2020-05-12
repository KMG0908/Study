package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8500_극장좌석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int sum = 0;
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++){
				int interval = Integer.parseInt(st.nextToken());
				sum += interval;
				max = Math.max(max, interval);
			}
			
			sb.append("#" + t + " " + (sum + n + max) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
