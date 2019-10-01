package d0822_d0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	public static int n, m, cctv_cnt = 0;
	public static ArrayList<int[]> cctv = new ArrayList<>();
	public static boolean[][] visited;
	public static int map[][], copy[][];
	public static int dir[][][][] = { 
			{ {{1, 0}}, {{-1, 0}}, {{0, 1}}, {{0, -1}} },	// 1번
			{ {{0, -1}, {0, 1}}, {{1, 0}, {-1, 0}} },		// 2번
			{ {{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}} },	// 3번
			{ {{0, -1}, {-1, 0}, {0, 1}}, {{-1, 0}, {0, 1}, {1, 0}}, {{0, 1}, {1, 0}, {0, -1}}, {{1, 0}, {0, -1}, {-1, 0}} },
			{ {{0, -1}, {-1, 0}, {0, 1}, {1, 0}} }	// 5번
			};
	public static int res = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		copy = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctv_cnt++;
					cctv.add(new int[] {map[i][j], i, j});
				}
			}
		}
		
		visited = new boolean[cctv_cnt][4];
		
		dfs(0);
		
		System.out.println(res);
	}
	
	public static void dfs(int depth) {
		if(depth == cctv_cnt) {
			mapCopy();
			
			for(int i=0; i<cctv_cnt; i++) {
				int range = 4;
				
				switch(cctv.get(i)[0]) {
				case 2:
					range = 2;
					break;
				case 5:
					range = 1;
					break;
				}
				
				for(int j=0; j<range; j++) {
					if(visited[i][j]) surveillance(cctv.get(i), j);
				}
			}
			
			if(res == -1) res = findZero();
			else res = Math.min(res, findZero());
			
			//print();
		}
		else {
			for(int i=0; i<4; i++) {
				if(!visited[depth][i]) {
					visited[depth][i] = true;
					dfs(depth + 1);
					visited[depth][i] = false;
				}
			}
		}
	}
	
	public static void surveillance(int[] info, int d) {
		int cctvNum = info[0];
		int locX = info[1];
		int locY = info[2];
		
		for(int i=0; i<dir[cctvNum-1][d].length; i++) {
			int dirX = dir[cctvNum-1][d][i][0];
			int dirY = dir[cctvNum-1][d][i][1];
			int nr = locX;
			int nc = locY;
			
			while(true) {
				nr += dirX;
				nc += dirY;
				if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if(copy[nr][nc] == 6) break;
					if(copy[nr][nc] == 0) copy[nr][nc] = '#';
				}
				else break;
			}
		}
	}
	
	public static int findZero() {
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) cnt++; 
			}
		}
		
		return cnt;
	}
	
	public static void mapCopy() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
