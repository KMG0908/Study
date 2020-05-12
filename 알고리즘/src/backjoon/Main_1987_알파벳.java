package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	public static int r, c, cnt = 1, res = 1;
	public static char[][] map;
	public static boolean[] checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		checked = new boolean[26];
		
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int x, int y) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int nr, nc;
		
		checked[map[x][y] - 'A'] = true;
		
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && !checked[map[nr][nc] - 'A']) {
				cnt++;
				res = Math.max(res, cnt);
				dfs(nr, nc);
			}
		}
		
		checked[map[x][y] - 'A'] = false;	// 백트랙킹
		cnt--;
	}
}
