package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순한회로 {
	public static int n, cost[][], total = 0, ans = Integer.MAX_VALUE;
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		cost = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int index, int depth) {
		if(depth == n - 1) {
			// 다시 회사로 돌아올 수 없다면 return
			if(cost[index][0] == 0) return;
			
			// 회사로 돌아오는 비용이 최소 비용보다 작을 경우에만
			if(total + cost[index][0] < ans) {
				total += cost[index][0];
				ans = Math.min(ans, total);
				total -= cost[index][0];
			}
		}
		else {
			for(int j=1; j<n; j++) {
				// 그 장소에 가는 비용이 최소 비용보다 작을 경우에만
				if(cost[index][j] != 0 && !visited[j] && total + cost[index][j] < ans) {
					visited[index] = true;
					total += cost[index][j];
					
					dfs(j, depth + 1);
					
					total -= cost[index][j];
					visited[index] = false;
				}
			}
		}
	}
}
