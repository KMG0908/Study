package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
	public static int len, knight[], goal[], dir[][] = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++){
			len = Integer.parseInt(br.readLine());
			visited = new boolean[len][len];
			
			knight = new int[2];
			goal = new int[2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			knight[0] = Integer.parseInt(st.nextToken());
			knight[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			goal[0] = Integer.parseInt(st.nextToken());
			goal[1] = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs());
		}
	}
	
	public static int bfs(){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(knight);
		visited[knight[0]][knight[1]] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();
				
				if(info[0] == goal[0] && info[1] == goal[1]) return cnt;
				
				int nr, nc;
				for(int j=0; j<8; j++){
					nr = info[0] + dir[j][0];
					nc = info[1] + dir[j][1];
					
					if(nr >= 0 && nr < len && nc >= 0 && nc < len && !visited[nr][nc]){
						queue.offer(new int[]{nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
}
