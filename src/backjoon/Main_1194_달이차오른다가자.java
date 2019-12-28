package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	public static int n, m, dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static char maze[][];
	public static boolean visited[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new char[n][m];
		visited = new boolean[1<<6][n][m];
		Info start = null;
		
		for(int i=0; i<n; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(maze[i][j] == '0') {
					maze[i][j] = '.';
					start = new Info(i, j, 0, 0);
				}
			}
		}

		System.out.println(bfs(start));
	}
	
	public static int bfs(Info start) {
		visited[0][start.x][start.y] = true;
		Queue<Info> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			
			if(maze[info.x][info.y] == '1') return info.count;
			
			int nr, nc, key, count;
			for(int i=0; i<4; i++) {
				nr = info.x + dir[i][0];
				nc = info.y + dir[i][1];
				key = info.key;
				count = info.count;
				
				// 범위 밖
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				// 이미 방문했을 경우
				if(visited[key][nr][nc]) continue;
				// 벽
				if(maze[nr][nc] == '#') continue;
				
				// 키 획득
				if(maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
					key |= (1 << (maze[nr][nc] - 'a'));
				}
				
				// 문일 경우
				if(maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
					// 해당 키가 없을 경우
					if((key & (1 << (maze[nr][nc] - 'A'))) == 0) continue;
				}
				
				visited[key][nr][nc] = true;
				queue.offer(new Info(nr, nc, key, count + 1));
			}
		}
		
		return -1;
	}
	
	public static class Info{
		int x;
		int y;
		int key;
		int count;
		
		public Info(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", key=" + key + ", count=" + count + "]";
		}
	}
}
