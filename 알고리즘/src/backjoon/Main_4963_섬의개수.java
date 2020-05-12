package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	public static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	public static int w, h, map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int[] loc = queue.poll();
				
				int nr, nc;
				for(int d=0; d<8; d++){
					nr = loc[0] + dir[d][0];
					nc = loc[1] + dir[d][1];
					
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1 && !visited[nr][nc]){
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
