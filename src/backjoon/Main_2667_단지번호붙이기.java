package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	public static int[][] map;
	public static boolean[][] visited;
	public static int n, num = 0, cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = Character.valueOf(ch[j]) - '0';
			}
		}

		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					num++;
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(num + "\n");
		
		for(int i=0; i<list.size(); i++) sb.append(list.get(i) + "\n");
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		cnt++;
		visited[x][y] = true;
		
		int nr, nc;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
	public static void bfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			cnt++;
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 1 && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
