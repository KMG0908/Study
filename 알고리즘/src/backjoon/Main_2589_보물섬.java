package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	public static int w, h, dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new boolean[w][h];
		
		for(int i=0; i<w; i++) {
			String str = br.readLine();
			for(int j=0; j<h; j++) {
				if(str.charAt(j) == 'L') map[i][j] = true;
			}
		}
		
		int max = 0;
		
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(map[i][j]) {
					boolean[][] temp = copy();
					
					Queue<Info> queue = new LinkedList<>();
					queue.offer(new Info(i, j, 0));
					temp[i][j] = false;
					
					while(!queue.isEmpty()) {
						Info info = queue.poll();
						max = Math.max(max, info.d);
						
						int nr, nc;
						for(int k=0; k<4; k++) {
							nr = info.x + dir[k][0];
							nc = info.y + dir[k][1];
							
							if(nr >= 0 && nr < w && nc >= 0 && nc < h && temp[nr][nc]) {
								queue.offer(new Info(nr, nc, info.d + 1));
								temp[nr][nc] = false;
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static boolean[][] copy(){
		boolean[][] temp = new boolean[w][h];
		
		for(int i=0; i<w; i++) {
			temp[i] = Arrays.copyOf(map[i], h);
		}
		
		return temp;
	}
	
	public static class Info {
		int x, y, d;
		
		public Info(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
