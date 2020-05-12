package d1007_d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9376_탈옥 {
	public static int h, w;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][][] sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h + 2][w + 2];
			sum = new int[h + 2][w + 2][3];
			
			int[][] start = new int[3][2];
			start[0][0] = 0;
			start[0][1] = 0;
			
			int idx = 1;
			
			for(int i=1; i<h+1; i++) {
				String str = br.readLine();
				for(int j=1; j<w+1; j++) {
					map[i][j] = str.charAt(j-1);
					if(map[i][j] == '$') {
						start[idx][0] = i;
						start[idx++][1] = j;
					}
				}
			}
			
			for(int i=0; i<3; i++) {
				bfs(start[i][0], start[i][1], i);
			}
			
			int[][] total = new int[h + 2][w + 2];
			int res = Integer.MAX_VALUE;
			
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					if(map[i][j] == '*') continue;
					for(int k=0; k<3; k++) {
						total[i][j] += sum[i][j][k];
					}
					// 문은 한 사람만 열어도 되므로
					if(map[i][j] == '#') total[i][j] -= 2;
					res = Math.min(res, total[i][j]);
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void bfs(int x, int y, int idx) {
		visited = new boolean[h + 2][w + 2];
		PriorityQueue<Path> queue = new PriorityQueue<>();
		queue.offer(new Path(x, y, 0));
		visited[x][y] = true;
		
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		while(!queue.isEmpty()) {
			Path path = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = path.x + dir[i][0];
				nc = path.y + dir[i][1];
				if(nr >= 0 && nr < h+2 && nc >= 0 && nc < w+2 && !visited[nr][nc] && map[nr][nc] != '*') {
					if(map[nr][nc] == '#') {
						queue.offer(new Path(nr, nc, path.count + 1));
						sum[nr][nc][idx] = path.count + 1; 
					}
					else {
						queue.offer(new Path(nr, nc, path.count));
						sum[nr][nc][idx] = path.count;
					}
					
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static class Path implements Comparable<Path> {
		int x;
		int y;
		int count;
		
		public Path(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public String toString() {
			return "Path [x=" + x + ", y=" + y + ", count=" + count + "]";
		}

		// 가장 문을 적게 통과한 것부터
		public int compareTo(Path o) {
			return this.count - o.count;
		}
	}
}
