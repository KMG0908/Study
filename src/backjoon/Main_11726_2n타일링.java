package backjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_11726_2n타일링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		if(n >= 1) dp[1] = 1;
		if(n >= 2) dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			// dp[i-2]에 가로로 된 직사각형이 붙을 경우 + dp[i-1]에 세로로 된 직사각형이 붙을 경우
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
