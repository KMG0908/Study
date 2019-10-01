package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int fr = Integer.parseInt(st.nextToken()) - 1;
		int fc = Integer.parseInt(st.nextToken()) - 1;
		
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		boolean visited[][] = new boolean[n][m];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		
		int count = -1;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			if(info[0] == fr && info[1] == fc) {
				count = info[2];
				break;
			}
			
			int nr, nc;
			
			ing:
			for(int k=0; k<4; k++) {
				nr = info[0] + dir[k][0];
				nc = info[1] + dir[k][1];
				
				switch(k) {
				case 0:		// 상
					if(nr < 0) continue ing;
					if(visited[nr][nc]) continue;
					
					for(int j=info[1]; j<info[1]+w; j++) {
						if(map[nr][j] == 1) continue ing;
					}
					break;
				case 1:		// 하
					if(nr + h - 1 >= n) continue ing;
					if(visited[nr][nc]) continue;
					
					for(int j=info[1]; j<info[1]+w; j++) {
						if(map[nr+h-1][j] == 1) continue ing;
					}
					break;
				case 2:		// 좌
					if(nc < 0) continue ing;
					if(visited[nr][nc]) continue;
					
					for(int i=info[0]; i<info[0]+h; i++) {
						if(map[i][nc] == 1) continue ing;
					}
					break;
				case 3:		// 우
					if(nc + w - 1 >= m) continue ing;
					if(visited[nr][nc]) continue;
					
					for(int i=info[0]; i<info[0]+h; i++) {
						if(map[i][nc+w-1] == 1) continue ing;
					}
					break;
				}
				
				queue.offer(new int[] {nr, nc, info[2] + 1});
				visited[nr][nc] = true;
			}
		}
		
		System.out.println(count);
	}
}
