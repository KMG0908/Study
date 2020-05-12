package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기 {
	public static int n, map[][];
	public static boolean visited[][];
	public static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	public static ArrayList<int[]> matrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			matrix = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] != 0 && !visited[i][j]) bfs(i, j);
				}
			}
			
			Collections.sort(matrix, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					// 크기 순서대로 정렬(크기가 같을 경우 행이 작은 순서대로)
					return o1[0] * o1[1] == o2[0] * o2[1]? o1[0] - o2[0] : o1[0] * o1[1] - o2[0] * o2[1];
				}
			});
			
			sb.append("#" + t + " ");
			
			int size = matrix.size();
			sb.append(size + " ");
			
			for(int i=0; i<size; i++) {
				sb.append(matrix.get(i)[0] + " " + matrix.get(i)[1] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int startX = x;
		int startY = y;
		
		int endX = x;
		int endY = y;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] != 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					
					endX = nr;
					endY = nc;
				}
			}
		}
		
		matrix.add(new int[] {endX - startX + 1, endY - startY + 1});
	}
}
