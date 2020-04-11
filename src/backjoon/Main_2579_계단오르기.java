package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고: https://kwanghyuk.tistory.com/4
public class Main_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[n];
		
		for(int i=0; i<n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n];
		dp[0] = stairs[0];
		if(n > 1) dp[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
		if(n > 2) dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		
		for(int i=3; i<n; i++) {
			// 마지막 계단의 전 계단을 밟고 올라온 경우 => 그 전전 계단은 밟지 않아야 함 => dp[i-3] + stairs[i-1] + stairs[i]
			// 마지막 계단의 전 계단을 밟고 올라오지 않은 경우 => 그 전전 계단을 밟고 올라와야 함 => dp[i-2] + stairs[i]
			dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
		}
		
		System.out.println(dp[n-1]);
	}
}
