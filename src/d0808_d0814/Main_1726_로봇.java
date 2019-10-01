package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {
	public static int cnt;
	public static int n, m;
	public static int[][] factory;
	public static boolean[][][] visited;
	public static int[] stop;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = n * m * 4;
		
		factory = new int[n][m];
		visited = new boolean[n][m][4];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				factory[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] start = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		start[0] = Integer.parseInt(st.nextToken()) - 1;
		start[1] = Integer.parseInt(st.nextToken()) - 1;
		start[2] = Integer.parseInt(st.nextToken()) - 1;
		
		stop = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		stop[0] = Integer.parseInt(st.nextToken()) - 1;
		stop[1] = Integer.parseInt(st.nextToken()) - 1;
		stop[2] = Integer.parseInt(st.nextToken()) - 1;
		
		bfs(start[0], start[1], start[2], 0);
		
		System.out.println(cnt);
	}

	public static void bfs(int x, int y, int direction, int count) {
		int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
		/* 동 서 남 북
		인덱스 차이 1: 동서 서남 남북 북동
		인덱스 차이 2: 동남 서북 남동 북서
		인덱스 차이 3: 동북 서동 남서 북남
		동서, 남북일 경우만 방향을 두 번 전환해야 함
		*/		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, direction, count});
		visited[x][y][direction] = true;
		
		while(!queue.isEmpty()) {
			int nr = 0, nc = 0;
			
			int[] information = queue.poll();
			int locX = information[0];
			int locY = information[1];
			int d = information[2];
			int c = information[3];
			
			if(locX == stop[0] && locY == stop[1] && d == stop[2]) {
				cnt = Math.min(cnt, c);
			}

			for(int i=0; i<4; i++) {
				// 전진
				if(d == i) {
					nr = locX + dir[i][0];
					nc = locY + dir[i][1];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && factory[nr][nc] == 0 /*&& !visited[nr][nc][i]*/) {
						// factory[nr][nc]가 벽이 아니라면 방문한 곳이더라도 그 너머로 전진할 수 있는지 확인해야 함
						// => 이 경우를 위해  if문(!visited[nr][nc][i])을 분리해야 함
						if(!visited[nr][nc][i]) {	
							queue.offer(new int[] {nr, nc, i, c + 1});
							visited[nr][nc][i] = true;
						}
						int k = 2;
						while(k > 0) {
							nr += dir[i][0];
							nc += dir[i][1];
							k--;
							if(nr >= 0 && nr < n && nc >= 0 && nc < m && factory[nr][nc] == 0) {
								if(!visited[nr][nc][i]) {
									queue.offer(new int[] {nr, nc, i, c + 1});
									visited[nr][nc][d] = true;
								}
							}
							else {
								nr -= dir[i][0];
								nc -= dir[i][1];
								break;
							}
						}
					}
				}
				// 제자리에서 회전만 하기
				else {
					if(!visited[locX][locY][i]) {
						if((d == 0 && i == 1) || (d == 2 && i == 3) ||
								(d == 1 && i == 0) || (d == 3 && i == 2)){
							queue.offer(new int[] {locX, locY, i, c + 2});
						}
						else {
							queue.offer(new int[] {locX, locY, i, c + 1});
						}
						visited[locX][locY][i] = true;
					}
				}
			}
		}
	}
}
