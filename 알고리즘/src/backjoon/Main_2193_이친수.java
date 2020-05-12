package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193_이친수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n+1][2];
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			// i번째 자리가 0인 경우 i-1번째 자리의 숫자에 상관없음
			dp[i][0] = dp[i-1][0] + dp[i-1][1]; 
			// i번째 자리가 1인 경우 i-1번재 자리의 숫자가 0인 경우만 가능
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[n][0] + dp[n][1]);
	}
}
