package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	public static int n, cnt, cntB;
	public static char picture[][];
	public static boolean[][] visited, visitedB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		picture = new char[n][n];
		visited = new boolean[n][n];
		visitedB = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			picture[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					cnt++;
					//dfs(picture[i][j], i, j);
					bfs(picture[i][j], i, j);
				}
				if(!visitedB[i][j]) {
					cntB++;
					//dfsB(picture[i][j], i, j);
					bfsB(picture[i][j], i, j);
				}
			}
		}
		
		System.out.println(cnt + " " + cntB);
	}
	
	public static void dfs(char letter, int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		visited[x][y] = true;
		
		int nr, nc;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && picture[nr][nc] == letter && !visited[nr][nc]) {
				dfs(letter, nr, nc);
			}
		}
	}
	
	public static void dfsB(char letter, int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		visitedB[x][y] = true;
		
		int nr, nc;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visitedB[nr][nc]) {
				if(letter == 'B') {
					if(picture[nr][nc] == letter) dfsB(letter, nr, nc);
				}
				else {
					if(picture[nr][nc] == 'R' || picture[nr][nc] == 'G') dfsB(letter, nr, nc);
				}
			}
		}
	}
	
	public static void bfs(char letter, int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {letter, x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[1] + dir[i][0];
				nc = info[2] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && picture[nr][nc] == info[0] && !visited[nr][nc]) {
					queue.offer(new int[] {info[0], nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void bfsB(char letter, int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {letter, x, y});
		visitedB[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[1] + dir[i][0];
				nc = info[2] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visitedB[nr][nc]) {
					if(letter == 'B') {
						if(picture[nr][nc] == letter) {
							queue.offer(new int[] {info[0], nr, nc});
							visitedB[nr][nc] = true;
						}
					}
					else {
						if(picture[nr][nc] == 'R' || picture[nr][nc] == 'G') {
							queue.offer(new int[] {info[0], nr, nc});
							visitedB[nr][nc] = true;
						}
					}
				}
			}
		}
	}
}
