package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	public static int n, map[][], max = 0;
	public static int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	public static int store[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			store = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(store[i], -1);
			}
			
			max = 0;
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					bfs(i, j);
				}
			}
			
			int room = n * n;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(store[i][j] == max) room = Math.min(room, map[i][j]);
				}
			}
			
			sb.append("#" + t + " " + room + " " + max + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		boolean visited[][] = new boolean[n][n];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, 1});
		visited[x][y] = true;
		
		int count = 0;
		
		exit:
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			
			count = info[2];
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[info[0]][info[1]] + 1 == map[nr][nc]) {
					if(store[nr][nc] != -1) {
						count += store[nr][nc];
						break exit;
					}
					
					queue.offer(new int[] {nr, nc, info[2] + 1});
					visited[nr][nc] = true;
					continue exit;
				}
			}
		}
		
		store[x][y] = count; 
		
		max = Math.max(max, count);
	}
}
