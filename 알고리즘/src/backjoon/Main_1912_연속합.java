package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int ans = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans = Math.min(ans, arr[i]);
		}
		
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			// i번째 숫자로 시작하는 경우와 전의 연속된 숫자 합에 i번째 숫자를 더하는 경우
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
