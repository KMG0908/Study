package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	public static int n, m, map[][], copy[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		copy = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(true) {
			visited = new boolean[n][m];
			
			copy(map, copy);
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			copy(copy, map);
			//print(map);

			time++;
			
			visited = new boolean[n][m];
			int count = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						check(i, j);
						count++;
					}
				}
			}
			
			if(count > 1) break;
			else if(count == 0) {
				time = 0;
				break;
			}
		}
		
		System.out.println(time);
	}
	
	// 빙산을 녹이는 함수
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
					if(map[nr][nc] == 0) {
						copy[info[0]][info[1]]--;
						if(copy[info[0]][info[1]] < 0) {
							copy[info[0]][info[1]] = 0;
						}
					}
					else {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	// 빙산이 몇 덩어리인지 구하기 위한 함수
	public static void check(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void copy(int ori[][], int copy[][]) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = ori[i][j];
			}
		}
	}
	
	public static void print(int[][] map) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
