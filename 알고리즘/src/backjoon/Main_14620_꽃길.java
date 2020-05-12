package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620_꽃길 {
	public static int n, g[][], ans = Integer.MAX_VALUE;
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		g = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 완전탐색 대신에 PriorityQueue를 사용하면 그리드 알고리즘이 되서 답이 안 나올 가능성이 있음
		// 제일 비용이 적게 드는 것부터 3개 고른다고 하더라도 그것을 모두 합친게 최소 비용이라고 장담할 수 없음
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int depth, int cost) {
		if(depth == 3) {
			ans = Math.min(ans, cost);
		}
		else {
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<n-1; j++) {
					if(!visited[i][j] && !visited[i-1][j] && !visited[i+1][j]
							&& !visited[i][j-1] && !visited[i][j+1]) {
						visited[i][j] = true;
						visited[i-1][j] = true;
						visited[i+1][j] = true;
						visited[i][j-1] = true;
						visited[i][j+1] = true;
						dfs(depth + 1, cost + g[i][j] + g[i-1][j] + g[i+1][j] + g[i][j-1] + g[i][j+1]);
						visited[i][j] = false;
						visited[i-1][j] = false;
						visited[i+1][j] = false;
						visited[i][j-1] = false;
						visited[i][j+1] = false;
					}
				}
			}
		}
	}
}
