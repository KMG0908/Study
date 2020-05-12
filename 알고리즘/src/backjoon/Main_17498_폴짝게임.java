package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17498_폴짝게임 {
	public static final int INF = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = INF;
			}
		}
		
		Arrays.fill(dp[0], 0);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<m; j++) {
				int nr, nc;
				for(int jump=1; jump<=d; jump++) {
					for(int a=1; a<=jump; a++) {
						int b = jump - a;
						
						nr = i - a;
						if(nr >= 0) {
							nc = j - b;
							if(nc >= 0) {
								dp[i][j] = Math.max(dp[i][j], dp[nr][nc] + map[nr][nc] * map[i][j]);
							}
							
							nc = j + b;
							if(nc < m) {
								dp[i][j] = Math.max(dp[i][j], dp[nr][nc] + map[nr][nc] * map[i][j]);
							}
						}
					}
				}
			}
		}
		
		int ans = INF;
		for(int j=0; j<m; j++) {
			ans = Math.max(ans, dp[n-1][j]);
		}
		
		System.out.println(ans);
	}
}
