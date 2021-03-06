package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 커밋 메세지 수정
public class Main_11052_카드구매하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++){
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				// dp[i-j] + p[j] => 카드 j개가 들어있는 카드팩을 구매하고 카드 i-j개를 구입
				dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
