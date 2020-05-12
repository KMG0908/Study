package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_7102_준홍이의카드놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] rate = new int[n + m + 1];
			
			for(int i=1; i<=n; i++){
				for(int j=1; j<=m; j++){
					rate[i + j]++;
				}
			}
			
			int max = 0;
			for(int i=2; i<=n+m; i++){
				max = Math.max(max, rate[i]);
			}
			
			sb.append("#" + t + " ");
			for(int i=2; i<=n+m; i++){
				if(rate[i] == max) sb.append(i + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
