package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	public static int dir[][] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	public static boolean visited[][];
	public static int n, map[][], len = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			visited = new boolean[n][n];
			len = 0;
			int max = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			ArrayList<int[]> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == max) list.add(new int[] {i, j});
				}
			}
			
			for(int[] start : list) {
				dfs(start[0], start[1], 1);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int depth=1; depth<=k; depth++) {
						if(map[i][j] - depth >= 0) {
							map[i][j] -= depth;
							for(int[] start : list) {
								dfs(start[0], start[1], 1);
							}
							map[i][j] += depth;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + len);
		}
	}
	
	public static void dfs(int x, int y, int cnt) {
		visited[x][y] = true;
		
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[x][y] > map[nr][nc]) {
				dfs(nr, nc, cnt + 1);
			}
		}
		
		visited[x][y] = false;
		len = Math.max(len, cnt);
	}
}
