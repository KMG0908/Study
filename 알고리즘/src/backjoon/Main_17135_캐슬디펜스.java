package backjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_17135_캐슬디펜스 {
	public static int n, m, d, map[][], max = 0;
	public static int numbers[] = new int[3];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 3) {
			int copy[][] = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					copy[i][j] = map[i][j];
				}
			}
			
			bfs(copy);
		}
		else {
			for(int i=start; i<m; i++) {
				if(!visited[i]) {
					visited[i] = true;
					numbers[depth] = i;
					dfs(i+1, depth+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void bfs(int[][] map) {
		int count = 0;
		
		while(!check(map)) {
			int loc[][] = new int[3][2];
			
			for(int i=0; i<3; i++) {
				Arrays.fill(loc[i], -1);
			}
			
			for(int k=0; k<3; k++) {
				int distance = d + 1;
				
				for(int i=n-1; i>=0; i--) {
					for(int j=0; j<m; j++) {
						if(map[i][j] == 1 && Math.abs(i - n) + Math.abs(j - numbers[k]) <= d) {
							int dif = Math.abs(i - n) + Math.abs(j - numbers[k]);
							// 가장 가까운 적 선택
							if(dif < distance) {
								distance = dif;
								loc[k][0] = i;
								loc[k][1] = j;
							}
							// 가장 가까운 적이 여러명이라면 제일 왼쪽에 있는 적 선택
							else if(dif == distance) {
								if(j < loc[k][1]) {
									loc[k][0] = i;
									loc[k][1] = j;
								}
							}
						}
					}
				}
			}
			
			for(int i=0; i<3; i++) {
				if(loc[i][0] != -1 && map[loc[i][0]][loc[i][1]] == 1) {
					map[loc[i][0]][loc[i][1]] = 0;
					count++;
				}
			}
			
			Arrays.fill(map[n-1], 0);
			
			for(int i=n-2; i>=0; i--) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 1) {
						map[i+1][j] = 1;
						map[i][j] = 0;
					}
				}
			}
		}
		
		max = Math.max(max, count);
	}
	
	public static boolean check(int[][] map) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		
		return true;
	}
}
