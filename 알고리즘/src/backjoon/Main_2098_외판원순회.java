package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
	public static int n, cost[][], dp[][];
	// INF를 Integer.MAX_VALUE로 잡으면 틀림...
	public static final int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		cost = new int[n][n];
		dp = new int[n][1 << n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(dfs(0, 1));
	}
	
	// cur 위치에서 visit에 기록되지 않은(방문하지 않은) 나머지를 방문하는 최소값
	public static int dfs(int cur, int visit) {
		// 모든 정점을 다 방문했다면 원래 정점으로(길이 있을 경우에만)
		if(visit == (1 << n) - 1) {
			if(cost[cur][0] != 0) return cost[cur][0];
			else return INF;
		}

		// 이미 방문했을 경우
		if(dp[cur][visit] != INF) return dp[cur][visit];
		
		for(int j=0; j<n; j++) {
			// 방문하지 않은 지점
			if((visit & (1 << j)) == 0 && cost[cur][j] != 0) {
				dp[cur][visit] = Math.min(dp[cur][visit], cost[cur][j] + dfs(j, visit | (1 << j)));
			}
		}
		
		return dp[cur][visit];
	}
}
