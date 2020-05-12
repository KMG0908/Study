package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	public static ArrayList<int[]> list;
	public static boolean visited[];
	public static int[] loc;
	public static int distance[][];
	public static int n, min = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			
			min = -1;
			list = new ArrayList<>();
			visited = new boolean[n];
			loc = new int[n+2];
			distance = new int[n+2][n+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n+2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(i >= 2) list.add(list.size() - 1, new int[] {x, y});	// 고객 좌표는 집 좌표 전에 넣기
				else list.add(new int[] {x, y});
			}
			
			loc[0] = 0;			// 회사
			loc[n + 1] = n + 1;	// 집 위치
			
			for(int i=0; i<n+1; i++) {
				for(int j=i; j<n+2; j++) {
					int diff = Math.abs(list.get(i)[0] - list.get(j)[0]) + Math.abs(list.get(i)[1] - list.get(j)[1]);
					distance[i][j] = diff;
					distance[j][i] = diff;
				}
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i=0; i<n+1; i++) {
				sum += distance[loc[i]][loc[i+1]];
			}
			
			
			if(min == -1) min = sum;
			else min = Math.min(min, sum);
		}
		else{
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					loc[depth + 1] = i + 1;
					dfs(i + 1, depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
