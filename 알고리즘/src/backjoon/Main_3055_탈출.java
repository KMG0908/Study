package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	public static int r, c;
	public static char[][] map;
	public static Queue<int[]> hedgehog = new LinkedList<>();
	public static Queue<int[]> water = new LinkedList<>();
	public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0; j<c; j++) {
				if(map[i][j] == 'S') hedgehog.offer(new int[] {i, j});
				else if(map[i][j] == '*') water.offer(new int[] {i, j});
			}
		}
		
		int res = 1;
		
		while(true) {
			if(hedgehog.size() == 0) {
				System.out.println("KAKTUS");
				break;
			}
			
			bfs_water();
			
			if(bfs_hedgehog()) {
				System.out.println(res);
				break;
			}
			
			res++;
		}
	}
	
	public static void bfs_water() {
		int size = water.size();
		
		for(int k=0; k<size; k++) {
			int[] info = water.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					water.add(new int[] {nr, nc});
				}
			}
		}
	}
	
	public static boolean bfs_hedgehog() {
		int size = hedgehog.size();
		
		for(int k=0; k<size; k++) {
			int[] info = hedgehog.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if(map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						hedgehog.add(new int[] {nr, nc});
					}
					else if(map[nr][nc] == 'D') {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
