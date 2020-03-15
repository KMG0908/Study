package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6730_장애물경주난이도 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			int n = Integer.parseInt(br.readLine());
			
			int[] race = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++){
				race[i] = Integer.parseInt(st.nextToken());
			}
			
			int up = 0;
			int down = 0;
			
			for(int i=0; i<n-1; i++){
				if(race[i] < race[i+1]) up = Math.max(up, race[i+1] - race[i]);
				else down = Math.max(down, race[i] - race[i+1]);
			}
			
			sb.append("#" + t + " " + up + " " + down + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
