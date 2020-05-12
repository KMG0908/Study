package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };	// 상, 하, 좌, 우
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[n][n];
			int micro[][] = new int[k][5];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				micro[i][0] = 1;										// 현재 살아있는가
				micro[i][1] = Integer.parseInt(st.nextToken());			// 세로 위치
				micro[i][2] = Integer.parseInt(st.nextToken());			// 가로 위치
				micro[i][3] = Integer.parseInt(st.nextToken());			// 미생물 수
				micro[i][4] = Integer.parseInt(st.nextToken()) - 1;		// 방향
				
				map[micro[i][1]][micro[i][2]] = i + 1;
			}
			
			while(m > 0) {
				int[][][] move = new int[n][n][2];		// [i][j][0]: 해당 좌표에 해당하는 방향이 있는 미생물 인덱스, [i][j][1]: 해당 좌표에 존재하는 미생물 수
				
				for(int i=0; i<k; i++) {
					if(micro[i][0] == -1) continue;
					
					micro[i][1] += dir[micro[i][4]][0];
					micro[i][2] += dir[micro[i][4]][1];
					
					if(micro[i][1] == 0 || micro[i][1] == n - 1 || micro[i][2] == 0 || micro[i][2] == n - 1) {
						micro[i][3] /= 2;
						
						// 방향 전환
						if(micro[i][4] % 2 == 1) micro[i][4]--;
						else micro[i][4]++;
					}
					
					// 이미 다른 미생물이 위치하고 있다면
					if(move[micro[i][1]][micro[i][2]][0] != 0) {
						int idx = move[micro[i][1]][micro[i][2]][0] - 1;
						// 원래 있던 것의 미생물 수가 더 클 경우 방향은 그대로
						if(micro[idx][3] > micro[i][3]) {
							micro[i][0] = -1;
						}
						// 아닐 경우는 방향 전환
						else {
							micro[idx][0] = -1;
							move[micro[i][1]][micro[i][2]][0] = i + 1;
						}
						move[micro[i][1]][micro[i][2]][1] += micro[i][3];
					}
					else {
						move[micro[i][1]][micro[i][2]][0] = i + 1;
						move[micro[i][1]][micro[i][2]][1] = micro[i][3];
					}
				}
				
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(move[i][j][0] != 0) {
							int idx = move[i][j][0] - 1;
							micro[idx][3] = move[i][j][1];
						}
						map[i][j] = move[i][j][0];
					}
				}
				
				m--;
			}
			
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] != 0) sum += micro[map[i][j] - 1][3];
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
