package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3184_양 {
	public static int r, c, sheep, wolf, dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++){
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] != '#' && !visited[i][j]){
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
	
	public static void bfs(int x, int y){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = true;
		
		int o = 0, v = 0;
		
		if(map[x][y] == 'o') o++;
		else if(map[x][y] == 'v') v++;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();

				int nr, nc;
				for(int j=0; j<4; j++){
					nr = info[0] + dir[j][0];
					nc = info[1] + dir[j][1];
					
					if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != '#' && !visited[nr][nc]){
						queue.offer(new int[]{nr, nc});
						visited[nr][nc] = true;
						if(map[nr][nc] == 'o') o++;
						else if(map[nr][nc] == 'v') v++;
					}
				}
			}
		}
		
		if(o > v) sheep += o;
		else wolf += v;
	}
}
