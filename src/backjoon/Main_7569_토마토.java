package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	public static int n, m, h, tomato[][][], dir[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	public static boolean visited[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		tomato = new int[h][n][m];
		visited = new boolean[h][n][m];
		
		for(int k=0; k<h; k++){
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++){
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		Queue<int[]> queue = new LinkedList<>();
		
		boolean flag = true; // 모든 토마토가 다 익어있는가?
		
		for(int k=0; k<h; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(tomato[k][i][j] != 0) {
						visited[k][i][j] = true;
						if(tomato[k][i][j] == 1) queue.offer(new int[]{k, i, j});
					}
					else flag = false;
				}
			}
		}
		
		if(flag) return 0;
		
		// 익은 토마토가 있을 경우 무조건 큐에 넣고, 큐가 비어있지 않다면 무조건 cnt++을 하므로 시작은 -1부터 해야함
		int cnt = -1;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			cnt++;
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();
				
				int nr, nc;
				for(int j=0; j<4; j++){
					nr = info[1] + dir[j][0];
					nc = info[2] + dir[j][1];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[info[0]][nr][nc]){
						queue.offer(new int[]{info[0], nr, nc});
						visited[info[0]][nr][nc] = true;
					}
				}
				
				if(info[0] + 1 < h && !visited[info[0] + 1][info[1]][info[2]]){
					queue.offer(new int[]{info[0] + 1, info[1], info[2]});
					visited[info[0] + 1][info[1]][info[2]] = true;
				}
				
				if(info[0] - 1 >= 0 && !visited[info[0] - 1][info[1]][info[2]]){
					queue.offer(new int[]{info[0] - 1, info[1], info[2]});
					visited[info[0] - 1][info[1]][info[2]] = true;
				}
			}
		}
		
		for(int k=0; k<h; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(!visited[k][i][j]) return -1;
				}
			}
		}
		
		return cnt;
	}
}
