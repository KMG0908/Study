package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	public static int n, m, r, c, l;
	public static int map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t + " " + bfs(r, c));
		}
	}
	
	public static int bfs(int x, int y) {
		int count = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			System.out.println(Arrays.toString(info));
			
			if(info[2] < l) count++;
			else if(info[2] >= l) break;
			
			switch(map[info[0]][info[1]]) {
			case 1:
				if(left(info[0], info[1]) && !visited[info[0]][info[1] - 1]) {
					queue.offer(new int[] {info[0], info[1] - 1, info[2] + 1});
					visited[info[0]][info[1] - 1] = true;
				}
				if(right(info[0], info[1]) && !visited[info[0]][info[1] + 1]) {
					queue.offer(new int[] {info[0], info[1] + 1, info[2] + 1});
					visited[info[0]][info[1] + 1] = true;
				}
				if(up(info[0], info[1]) && !visited[info[0] - 1][info[1]]) {
					queue.offer(new int[] {info[0] - 1, info[1], info[2] + 1});
					visited[info[0] - 1][info[1]] = true;
				}
				if(down(info[0], info[1]) && !visited[info[0] + 1][info[1]]) {
					queue.offer(new int[] {info[0] + 1, info[1], info[2] + 1});
					visited[info[0] + 1][info[1]] = true;
				}
				
				break;
			case 2:
				if(up(info[0], info[1]) && !visited[info[0] - 1][info[1]]) {
					queue.offer(new int[] {info[0] - 1, info[1], info[2] + 1});
					visited[info[0] - 1][info[1]] = true;
				}
				if(down(info[0], info[1]) && !visited[info[0] + 1][info[1]]) {
					queue.offer(new int[] {info[0] + 1, info[1], info[2] + 1});
					visited[info[0] + 1][info[1]] = true;
				}
				
				break;
			case 3:
				if(left(info[0], info[1]) && !visited[info[0]][info[1] - 1]) {
					queue.offer(new int[] {info[0], info[1] - 1, info[2] + 1});
					visited[info[0]][info[1] - 1] = true;
				}
				if(right(info[0], info[1]) && !visited[info[0]][info[1] + 1]) {
					queue.offer(new int[] {info[0], info[1] + 1, info[2] + 1});
					visited[info[0]][info[1] + 1] = true;
				}
				
				break;
			case 4:
				if(right(info[0], info[1]) && !visited[info[0]][info[1] + 1]) {
					queue.offer(new int[] {info[0], info[1] + 1, info[2] + 1});
					visited[info[0]][info[1] + 1] = true;
				}
				if(up(info[0], info[1]) && !visited[info[0] - 1][info[1]]) {
					queue.offer(new int[] {info[0] - 1, info[1], info[2] + 1});
					visited[info[0] - 1][info[1]] = true;
				}
				
				break;
			case 5:
				if(right(info[0], info[1]) && !visited[info[0]][info[1] + 1]) {
					queue.offer(new int[] {info[0], info[1] + 1, info[2] + 1});
					visited[info[0]][info[1] + 1] = true;
				}
				if(down(info[0], info[1]) && !visited[info[0] + 1][info[1]]) {
					queue.offer(new int[] {info[0] + 1, info[1], info[2] + 1});
					visited[info[0] + 1][info[1]] = true;
				}
				
				break;
			case 6:
				if(left(info[0], info[1]) && !visited[info[0]][info[1] - 1]) {
					queue.offer(new int[] {info[0], info[1] - 1, info[2] + 1});
					visited[info[0]][info[1] - 1] = true;
				}
				if(down(info[0], info[1]) && !visited[info[0] + 1][info[1]]) {
					queue.offer(new int[] {info[0] + 1, info[1], info[2] + 1});
					visited[info[0] + 1][info[1]] = true;
				}
				
				break;
			case 7:
				if(left(info[0], info[1]) && !visited[info[0]][info[1] - 1]) {
					queue.offer(new int[] {info[0], info[1] - 1, info[2] + 1});
					visited[info[0]][info[1] - 1] = true;
				}
				if(up(info[0], info[1]) && !visited[info[0] - 1][info[1]]) {
					queue.offer(new int[] {info[0] - 1, info[1], info[2] + 1});
					visited[info[0] - 1][info[1]] = true;
				}
				
				break;
			}
		}
		
		return count;
	}
	
	public static boolean left(int x, int y) {
		if(y - 1 >= 0) {
			switch(map[x][y - 1]) {
			case 1:
			case 3:
			case 4:
			case 5:
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean right(int x, int y) {
		if(y + 1 < m) {
			switch(map[x][y + 1]) {
			case 1:
			case 3:
			case 6:
			case 7:
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean up(int x, int y) {
		if(x - 1 >= 0) {
			switch(map[x - 1][y]) {
			case 1:
			case 2:
			case 5:
			case 6:
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean down(int x, int y) {
		if(x + 1 < n) {
			switch(map[x + 1][y]) {
			case 1:
			case 2:
			case 4:
			case 7:
				return true;
			}
		}
		
		return false;
	}
}
