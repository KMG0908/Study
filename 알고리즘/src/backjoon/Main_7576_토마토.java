package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	public static int n, m, tomato[][], dir[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		tomato = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++){
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(tomato[i][j] != 0) {
					visited[i][j] = true;
					if(tomato[i][j] == 1) queue.offer(new int[]{i, j});
				}
			}
		}
		
		// 익은 토마토가 있을 경우 무조건 큐에 넣고, 큐가 비어있지 않다면 무조건 cnt++을 하므로 시작은 -1부터 해야함
		int cnt = -1;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			cnt++;
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();
				
				int nr, nc;
				for(int j=0; j<4; j++){
					nr = info[0] + dir[j][0];
					nc = info[1] + dir[j][1];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
						queue.offer(new int[]{nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(!visited[i][j]) return -1;
			}
		}
		
		return cnt;
	}
}
