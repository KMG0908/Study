package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6913_동철이의프로그래밍대회 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] problem = new int[n];
			
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++){
					int value = Integer.parseInt(st.nextToken());
					
					if(value == 1) problem[i]++;
				}
			}
			
			int max = 0;
			for(int i=0; i<n; i++){
				max = Math.max(max, problem[i]);
			}
			
			int cnt = 0;
			for(int i=0; i<n; i++){
				if(problem[i] == max) cnt++;
			}
			
			sb.append("#" + t + " " + cnt + " " + max + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
