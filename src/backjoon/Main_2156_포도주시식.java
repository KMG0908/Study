package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] juice = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			juice[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n+1];
		dp[1] = juice[1];
		if(n > 1) dp[2] = juice[1] + juice[2];
		
		for(int i=3; i<=n; i++) {
			/*
			 * i번째 잔을 마시는 경우
			 * 1. i-1번째 잔을 마시지 않은 경우 i-2번재 잔을 고를 수 있음 => dp[i-2] + juice[i]
			 * 2. i-1번째 잔을 마신 경우 i-2번재 잔은 마실 수 없음 => dp[i-3] + juice[i-1] + juice[i]
			 * i번째 잔을 마시지 않는 경우
			 * dp[i-1]
			 */
			dp[i] = Math.max(dp[i-3] + juice[i-1] + juice[i], Math.max(dp[i-2] + juice[i], dp[i-1]));
		}
		
		System.out.println(dp[n]);
	}
}
