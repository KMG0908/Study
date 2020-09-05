package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {
	public static int n, m, map[][];
	public static boolean visited[][];
	public static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0, max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = info[0] + dir[i][0];
				int nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1 && !visited[nr][nc]) {
					cnt++;
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		return cnt;
	}
}
