package SWExpert;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution_5656_벽돌깨기 {
	public static int n, w, h, number[], map[][], min;
	public static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			number = new int[n];
			min = h * w;
			dfs(0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void dfs(int depth) {
		if(depth == n) {
			bfs();
		}
		else {
			for(int i=0; i<w; i++) {
				number[depth] = i;
				dfs(depth + 1);
			}
		}
	}
	
	public static void bfs() {
		int[][] copy = new int[h][w];
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		ing:
		for(int c=0; c<n; c++) {
			int j = number[c];
			for(int i=0; i<h; i++) {
				// 벽돌일 경우
				if(copy[i][j] != 0) {
					boolean[][] visited = new boolean[h][w];
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						int[] info = queue.poll();
						
						for(int k=0; k<4; k++) {
							int cnt = copy[info[0]][info[1]] - 1;
							int nr = info[0];
							int nc = info[1];
							
							while(cnt > 0) {
								nr += dir[k][0];
								nc += dir[k][1];
								
								if(nr >= 0 && nr < h && nc >= 0 && nc < w) {
									// 방문하지 않았을 경우
									if(!visited[nr][nc]) {
										if(copy[nr][nc] != 0) {
											queue.offer(new int[] {nr, nc});
										}
										visited[nr][nc] = true;
									}
									cnt--;
								}
								else break;
							}
						}
					}
					
					// 벽돌 부수기
					for(int x=0; x<h; x++) {
						for(int y=0; y<w; y++) {
							if(visited[x][y]) copy[x][y] = 0;
						}
					}
					
					// 벽돌 내리기
					for(int y=0; y<w; y++) {
						Queue<Integer> q = new LinkedList<>();
						for(int x=h-1; x>=0; x--) {
							if(copy[x][y] != 0) q.offer(copy[x][y]);
						}
						
						int x = h - 1;
						while(!q.isEmpty()) {
							int val = q.poll();
							copy[x--][y] = val;
						}
						for(int k=x; k>=0; k--) copy[k][y] = 0;
					}
					
					continue ing;
				}
			}
		}
		
		int cnt = 0;
		for(int x=0; x<h; x++) {
			for(int y=0; y<w; y++) {
				if(copy[x][y] != 0) cnt++;
			}
		}
		
		min = Math.min(min, cnt);
	}
}
