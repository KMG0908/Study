package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 커밋 메세지 수정
public class Main_2178_미로탐색 {
	public static int n, m, dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	public static char maze[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++){
			maze[i] = br.readLine().toCharArray();
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		int cnt = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			cnt++;
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();
				
				if(info[0] == n-1 && info[1] == m - 1) return cnt;
				
				int nr, nc;
				for(int j=0; j<4; j++){
					nr = info[0] + dir[j][0];
					nc = info[1] + dir[j][1];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] == '1' && !visited[nr][nc]){
						queue.offer(new int[]{nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return 0;
	}
}
