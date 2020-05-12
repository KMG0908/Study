package backjoon;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_2583_영역구하기 {
	public static int m, n, map[][], size;
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int leftY = Integer.parseInt(st.nextToken());
			int leftX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			
			for(int x=leftX; x<rightX; x++) {
				for(int y=leftY; y<rightY; y++) {
					map[x][y] = 1;
				}
			}
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		
		int cnt = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					size = 0;
					//dfs(i, j);
					bfs(i, j);
					cnt++;
					list.add(size);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static void dfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int nr, nc;
		
		visited[x][y] = true;
		size++;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < m && nc >= 0 && nc < n && map[nr][nc] == 0 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
	public static void bfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int nr, nc;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			size++;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < m && nc >= 0 && nc < n && map[nr][nc] == 0 && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
