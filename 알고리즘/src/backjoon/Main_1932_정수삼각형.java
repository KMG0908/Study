package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][n+1];
		dp[1][1] = tri[1][1];
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1] + tri[i][j], dp[i-1][j] + tri[i][j]);
			}
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		
		System.out.println(ans);
	}
}
