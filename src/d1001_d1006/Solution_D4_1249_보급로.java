package d1001_d1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 문제 푼 시간: 34분
 */
public class Solution_D4_1249_보급로 {
	public static int n, res;
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new char[n][n];
			visited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			bfs(0, 0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	public static void bfs(int x, int y) {
		PriorityQueue<Path> queue = new PriorityQueue<>();
		queue.offer(new Path(x, y, 0, 0));
		visited[x][y] = true;
		
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		while(!queue.isEmpty()) {
			Path path = queue.poll();
			
			if(path.time > 0) {
				path.time--;
				path.total++;
			}
			
			if(path.x == n - 1 && path.y == n - 1) {
				res = path.total;
				break;
			}
			
			if(path.time == 0) {
				int nr, nc;
				for(int i=0; i<4; i++) {
					nr = path.x + dir[i][0];
					nc = path.y + dir[i][1];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
						queue.offer(new Path(nr, nc, map[nr][nc] - '0', path.total));
						visited[nr][nc] = true;
					}
				}
			}
			else {
				queue.offer(path);
			}
		}
	}
	
	static class Path implements Comparable<Path>{
		int x, y, time, total;
		
		public Path(int x, int y, int time, int total) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.total = total;
		}

		// 총 시간이 가장 짧은 것부터
		// 총 시간이 같다면 비용이 가장 적은 것부터
		public int compareTo(Path o) {
			return this.total == o.total ? this.time - o.time : this.total - o.total;
		}

		public String toString() {
			return "Path [x=" + x + ", y=" + y + ", time=" + time + ", total=" + total + "]";
		}
	}
}
