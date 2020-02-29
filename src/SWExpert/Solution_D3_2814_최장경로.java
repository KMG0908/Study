package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2814_최장경로 {
	public static int n, m, result;
	public static boolean[] map[], visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new boolean[n + 1][n + 1];
			visited = new boolean[n + 1];
			result = 0;
			
			for(int i=0; i<m; i++){
				st = new StringTokenizer(br.readLine(), " ");
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a][b] = true;
				map[b][a] = true;
			}
			
			for(int i=1; i<=n; i++){
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int i, int depth){
		if(result < depth) result = depth;
		
		for(int j=1; j<=n; j++){
			if(map[i][j] && !visited[j]){
				visited[j] = true;
				dfs(j, depth + 1);
				visited[j] = false;
			}
		}
	}
}
