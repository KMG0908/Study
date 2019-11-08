package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	public static int n, count[][];
	public static char[][] map;
	public static int[][] dir = { {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1} };
	public static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new char[n][n];
			count = new int[n][n];
			visited = new boolean[n][n];
			PriorityQueue<Find> queue = new PriorityQueue<>();
			
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == '.') queue.offer(new Find(i, j));
				}
			}
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				Find find = queue.poll();
				
				if(visited[find.x][find.y]) {
					continue;
				}
				
				check(find.x, find.y);
				
				cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	public static void check(int x, int y) {
		if(count[x][y] == 0) {
			int nr, nc;
			for(int i=0; i<8; i++) {
				nr = x + dir[i][0];
				nc = y + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
					visited[nr][nc] = true;
					check(nr, nc);
				}
			}
		}
	}
	
	public static class Find implements Comparable<Find> {
		int x;
		int y;
		int mine;
		
		public Find(int x, int y) {
			this.x = x;
			this.y = y;
			
			int nr, nc, cnt = 0;
			for(int i=0; i<8; i++) {
				nr = x + dir[i][0];
				nc = y + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if(map[nr][nc] == '*') {
						cnt++;
					}
				}
			}
			
			this.mine = cnt;
			
			count[x][y] = cnt;
		}

		public int compareTo(Find o) {
			return this.mine - o.mine;
		}
		
		public String toString() {
			return "Find [x=" + x + ", y=" + y + ", mine=" + mine + "]";
		}
	}
}
