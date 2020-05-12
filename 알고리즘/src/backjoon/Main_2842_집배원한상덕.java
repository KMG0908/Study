package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2842_집배원한상덕 {
	public static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	public static int n, altitude[][], people[], house, ans = Integer.MAX_VALUE;
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		altitude = new int[n][n];
		visited = new boolean[n][n];
		people = new int[2];
		house = 0;
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'P') {
					people[0] = i;
					people[1] = j;
				}
				else if(map[i][j] == 'K') house++;
			}
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				altitude[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(people[0], people[1], altitude[people[0]][people[1]], altitude[people[0]][people[1]]);
		
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int min, int max) {
		if(max - min > ans) return;
		
		if(house == 0) {
			ans = max - min;
		}
		else {
			visited[x][y] = true;
			
			int nr, nc;
			for(int i=0; i<8; i++) {
				nr = x + dir[i][0];
				nc = y + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
					if(altitude[nr][nc] < min) min = altitude[nr][nc];
					else if(altitude[nr][nc] > max) max = altitude[nr][nc];
					
					if(map[nr][nc] == 'K') house--;
					dfs(nr, nc, min, max);
				}
			}
			
			visited[x][y] = false;
		}
	}
}
