package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	public static int r, c, count = 0;;
	public static char map[][];
	public static boolean visited[][];
	public static int dir[][] = { {-1, 1}, {0, 1}, {1, 1} };
	public static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map= new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<r; i++) {
			flag = false;
			dfs(i, 0);
		}
		
		System.out.println(count);
	}
	public static void dfs(int x, int y) {
		// 도달하지 못했을 경우 다른 출발점에서 출발하더라도 그 자리를 거치게 된다면 똑같이 실패할 것이므로 막은 상태(true)로 두어야 함
		visited[x][y] = true;
		
		if(y == c - 1) {
			flag = true;
			count++;
			return;
		}
		
		int nr, nc;
		for(int i=0; i<3; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(flag) return;
			
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && map[nr][nc] == '.') {
				dfs(nr, nc);
			}
		}
	}
}