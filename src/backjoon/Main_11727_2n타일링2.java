package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2n타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		if(n >= 1) dp[1] = 1;
		if(n >= 2) dp[2] = 3;
		
		for(int i=3; i<=n; i++){
			// dp[i-1]에 세로로 된 직사각형이 붙을 경우 + dp[i-2]에 가로(2*1)로 된 직사각형이 붙을 경우  + dp[i-2]에 2*2 직사각형이 붙을 경우
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
