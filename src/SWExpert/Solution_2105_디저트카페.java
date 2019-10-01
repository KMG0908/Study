package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] cafe = new int[n][n];
			boolean[] visited = new boolean[101];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int dir[][] = { {1, 1}, {1, -1}, {-1, -1}, {-1, 1} };
			
			int max = -1;
			
			for(int i=0; i<n-2; i++) {
				for(int j=1; j<n-1; j++) {
					// ↘  길이
					for(int r=1; r<=n-2-i; r++) {
						// ↙ 길이
						ing:
						for(int l=1; l<=j; l++) {
							visited = new boolean[101];
							int cnt = 0;
							
							int nr = i, nc = j;
							for(int k=0; k<4; k++) {
								if(k % 2 == 0) {
									for(int times=0; times<r; times++) {
										nr += dir[k][0];
										nc += dir[k][1];
										
										if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[cafe[nr][nc]]) {
											visited[cafe[nr][nc]] = true;
											cnt++;
										}
										else continue ing;
									}
								}
								else {
									for(int times=0; times<l; times++) {
										nr += dir[k][0];
										nc += dir[k][1];
										
										if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[cafe[nr][nc]]) {
											visited[cafe[nr][nc]] = true;
											cnt++;
										}
										else continue ing;
									}
								}
							}
							
							max = Math.max(max, cnt);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
