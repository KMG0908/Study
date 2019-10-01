package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 {
	public static int r, c, max = 1, cnt = 1;
	public static char[][] board;
	public static boolean[] check = new boolean[26];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			max = 1;
			cnt = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			board = new char[r][c];
			
			for(int i=0; i<r; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void dfs(int x, int y) {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		check[board[x][y] - 'A'] = true;
		
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = x + dir[i][0];
			nc = y + dir[i][1];
			
			if(nr >= 0 && nr < r && nc >= 0 && nc < c && !check[board[nr][nc] - 'A']) {
				cnt++;
				max = Math.max(max, cnt);
				dfs(nr, nc);
			}
		}
		
		check[board[x][y] - 'A'] = false;
		cnt--;
	}
}
