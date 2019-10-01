package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	public static int n, l, r, country[][];
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		country = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		
		while(true) {
			visited = new boolean[n][n];
			int cnt = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			if(cnt == n * n) break;
			else res++;
		}
		
		System.out.println(res);
	}
	
	public static void bfs(int x, int y) {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> coordinate = new LinkedList<>();
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		coordinate.offer(new int[] {x, y});
		int sum = country[x][y];
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
					int diff = Math.abs(country[nr][nc] - country[info[0]][info[1]]);
					if(diff >= l && diff <= r) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
						coordinate.offer(new int[] {nr, nc});
						sum += country[nr][nc];
					}
				}
			}
		}
		
		int people = sum / coordinate.size();
			
		while(!coordinate.isEmpty()) {
			int[] info = coordinate.poll();
			country[info[0]][info[1]] = people;
		}
	}
}
