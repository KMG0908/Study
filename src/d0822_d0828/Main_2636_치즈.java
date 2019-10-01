package d0822_d0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	public static int n, m, cheese[][];
	public static boolean visited[][], melt[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cheese = new int[n][m];
		visited = new boolean[n][m];
		melt = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sec = 0, res = 0;
		
		ing:
		while(true) {
			visited = new boolean[n][m];
			melt = new boolean[n][m];
			
			air(0, 0);			// 공기 부분은 -1로
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(cheese[i][j] == 1 && !visited[i][j]) bfs(i, j);
				}
			}
			
			sec++;
			res = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(cheese[i][j] == 1) {
						if(!melt[i][j]) {
							melting();
							continue ing;
						}
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(melt[i][j]) res++;
				}
			}
			
			break;
		}
		
		System.out.println(sec);
		System.out.println(res);
	}
	
	public static void air(int x, int y) {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		cheese[x][y] = -1;
		
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && cheese[nr][nc] != 1 && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					cheese[nr][nc] = -1;
				}
			}
		}
	}
	
	public static void bfs(int x, int y) {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(cheese[nr][nc] == 1) {
					if(!visited[nr][nc]) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
				else if(cheese[nr][nc] == -1) {	// 공기와 맞닿아 있는 경우
					melt[info[0]][info[1]] = true;
				}
			}
		}
	}
	
	public static void melting() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(melt[i][j]) cheese[i][j] = -1;
			}
		}
	}
}
