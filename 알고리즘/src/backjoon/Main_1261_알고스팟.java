package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	public static int n, m;
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		PriorityQueue<Path> queue = new PriorityQueue<>();
		queue.offer(new Path(0, 0, 0));
		visited[0][0] = true;
		
		int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		while(!queue.isEmpty()) {
			Path path = queue.poll();
			
			if(path.x == n - 1 && path.y == m - 1) return path.breakWall;
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = path.x + dir[i][0];
				nc = path.y + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
					if(map[nr][nc] == '1') queue.offer(new Path(nr, nc, path.breakWall + 1));
					else queue.offer(new Path(nr, nc, path.breakWall));
					
					visited[nr][nc] = true;
				}
			}
		}
		
		return -1;
	}
	
	public static class Path implements Comparable<Path>{
		int x;
		int y;
		int breakWall;
		
		public Path(int x, int y, int breakWall) {
			super();
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
		}

		@Override
		public String toString() {
			return "Path [x=" + x + ", y=" + y + ", breakWall=" + breakWall + "]";
		}

		@Override
		public int compareTo(Path o) {
			return this.breakWall - o.breakWall;
		}
	}
}
