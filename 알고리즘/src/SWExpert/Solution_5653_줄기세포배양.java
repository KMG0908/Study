package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int cell[][][] = new int[n + k][m + k][3];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					int life = Integer.parseInt(st.nextToken());
					if(life != 0) {
						cell[i + k/2][j + k/2][0] = 1;		// 비활성 상태
						cell[i + k/2][j + k/2][1] = life;	// 초기 생명력
						cell[i + k/2][j + k/2][2] = life;	// 시간에 따라 달라지는 것	
					}
				}
			}
			
			int time = k;
			while(time > 0) {
				time--;
				
				// 번식
				for(int i=0; i<n+k; i++) {
					for(int j=0; j<m+k; j++) {
						// 활성 상태일 경우
						if(cell[i][j][0] == 2) {
							int nr, nc;
							
							for(int d=0; d<4; d++) {
								nr = i + dir[d][0];
								nc = j + dir[d][1];
								
								if(cell[nr][nc][0] == 0) {
									cell[nr][nc][0] = 3;
									cell[nr][nc][1] = cell[i][j][1];
									cell[nr][nc][2] = cell[nr][nc][1] + 1;
								}
								else if(cell[nr][nc][0] == 3) {
									if(cell[i][j][1] > cell[nr][nc][1]) {
										cell[nr][nc][1] = cell[i][j][1];
										cell[nr][nc][2] = cell[nr][nc][1] + 1;
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<n+k; i++) {
					for(int j=0; j<m+k; j++) {
						if(cell[i][j][0] == 3) cell[i][j][0] = 1;
					}
				}
				
				// 생명력 -1
				for(int i=0; i<n+k; i++) {
					for(int j=0; j<m+k; j++) {
						if(cell[i][j][0] >= 1) {	// 비활성 상태, 활성 상태일 경우
							cell[i][j][2]--;
							if(cell[i][j][2] == 0) {
								if(cell[i][j][0] == 1) {
									cell[i][j][0] = 2;		// 활성 상태
									cell[i][j][2] = cell[i][j][1];
								}
								else if(cell[i][j][0] == 2) cell[i][j][0] = -1;	// 죽은 상태
							}
						}
					}
				}
			}
			
			int count = 0;
			for(int i=0; i<n+k; i++) {
				for(int j=0; j<m+k; j++) {
					if(cell[i][j][0] >= 1) count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}
