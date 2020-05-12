package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	public static int cnt = 0;
	public static int[][] ground;
	public static boolean[][] visited;
	public static int m, n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			ground = new int[n][m];
			visited = new boolean[n][m];
			
			int k = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				ground[row][col] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!visited[i][j] && ground[i][j] == 1) {
						//dfs(i, j);
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && ground[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
	
	public static void bfs(int r, int c) {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] location = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = location[0] + dir[i][0];
				int nc = location[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && ground[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
