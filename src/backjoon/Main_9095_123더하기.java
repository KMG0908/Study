package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고: https://spillmoon.tistory.com/170
public class Main_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			
			if(n >= 1) dp[1] = 1;
			if(n >= 2) dp[2] = 2;
			if(n >= 3) dp[3] = 4;
			
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
			}
			
			System.out.println(dp[n]);
		}
	}
}
