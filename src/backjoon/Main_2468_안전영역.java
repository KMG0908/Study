package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	public static int n, area[][], copyArea[][];
	public static boolean visited[][];
	public static int cnt = 0, res = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		area = new int[n][n];
		copyArea = new int[n][n];
		
		StringTokenizer st;
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] > max) max = area[i][j];
			}
		}
		
		for(int h=0; h<max; h++) {
			flood(h);
			visited = new boolean[n][n];
			
			cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(copyArea[i][j] == 1 && !visited[i][j]) {
						cnt++;
						//dfs(i, j);
						bfs(i, j);
					}
				}
			}
			
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);
	}
	
	public static void dfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int nr, nc;
		
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && copyArea[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
	public static void bfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int nr, nc;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && copyArea[nr][nc] == 1 && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	
	public static void flood(int height) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(area[i][j] > height) copyArea[i][j] = 1;	// 물에 잠기지 않음
				else copyArea[i][j] = 0;					// 물에 잠김
			}
		}
	}
}
