package IM_AD_모의테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* SW Expert Academy 5648번과 동일 */
public class Solution_AD_원자소멸시뮬레이션 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		// 좌표 상에서 상하좌우
		int[][] dir = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
		int[][] atoms = new int[1000][5];
		int[][] map = new int[4002][4002];
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			int atom = Integer.parseInt(br.readLine());
			
			for(int i=0; i<atom; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				atoms[i][0] = 1;	// 원자가 활성화 상태
				atoms[i][1] = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				atoms[i][2] = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				atoms[i][3] = Integer.parseInt(st.nextToken());
				atoms[i][4] = Integer.parseInt(st.nextToken());
			}
			
			int size = 0;
			int cnt = atom;
			
			while(true) {
				for(int i=0; i<atom; i++) {
					int nr = atoms[i][1] + dir[atoms[i][3]][0];
					int nc = atoms[i][2] + dir[atoms[i][3]][1];
					
					if(nr < 0 || nr >= 4002 || nc < 0 || nc >= 4002) {
						atoms[i][0] = -1;
						map[atoms[i][1]][atoms[i][2]] = 0;
						cnt--;
						continue;
					}
					
					if(map[nr][nc] == 1) {
						for(int j=0; j<atom; j++) {
							if(i==j) continue;
							
							if(atoms[j][0] != -1 && atoms[j][1] == nr && atoms[j][2] == nc) {
								cnt--;
								atoms[j][0] = -1;
								size += atoms[j][4];
								break;
							}
						}
						
						atoms[i][0] = 0;
						// 다른 원자와 또 충돌할 가능성이 있으므로 맵에서 삭제하는 건 나중에
						// -> 가장 나중에 충돌한 것만 0으로 남고 나머지는 -1로 되어 있음
					}
					
					map[atoms[i][1]][atoms[i][2]] = 0;
					map[nr][nc] = 1;
					atoms[i][1] = nr;
					atoms[i][2] = nc;
				}
				
				for(int i=0; i<atom; i++) {
					if(atoms[i][0] == 0) {
						cnt--;
						atoms[i][0] = -1;
						size += atoms[i][4];
						map[atoms[i][1]][atoms[i][2]] = 0;
					}
				}
				
				if(cnt != atom) {
					int idx = 0;
					for(int i=0; i<atom; i++) {
						if(atoms[i][0] == 1) atoms[idx++] = Arrays.copyOf(atoms[i], 5);
					}
					atom = cnt;
				}
				
				if(cnt <= 1) {
					for(int i=0; i<cnt; i++) {
						map[atoms[i][1]][atoms[i][2]] = 0;
					}
					break;
				}
			}
			
			sb.append("#" + t + " " + size + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
