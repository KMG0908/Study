package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[r][c];
		int[][] shark = new int[m][5];
		
		int dir[][] = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;	// 상어 행
			int y = Integer.parseInt(st.nextToken()) - 1;	// 상어 열
			int s = Integer.parseInt(st.nextToken());		// 속력
			int d = Integer.parseInt(st.nextToken()) - 1;	// 이동 방향
			int z = Integer.parseInt(st.nextToken());		// 크기
			
			shark[i] = new int[] {x, y, s, d, z};
			
			map[x][y] = i + 1;
		}
		
		int size = 0;
		
		for(int k=0; k<c; k++) {
			// 해당 열에서 땅과 제일 가까운 상어 잡기
			for(int i=0; i<r; i++) {
				if(map[i][k] != 0) {
					size += shark[map[i][k]-1][4];
					map[i][k] = 0;
					break;
				}
			}
			
			int[][] copyMap = new int[r][c];
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(map[i][j] != 0) {
						int sharkNum = map[i][j] - 1;
						int sharkInfo[] = shark[sharkNum];
						int nr = sharkInfo[0] + dir[sharkInfo[3]][0] * sharkInfo[2];
						int nc = sharkInfo[1] + dir[sharkInfo[3]][1] * sharkInfo[2];
						
						// 경계를 만나게 되는 경우
						if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
							switch(sharkInfo[3]) {
							case 0:
								nr = Math.abs(nr);	// 제일 윗칸 기준

								int cnt = nr / (r-1);
								nr = nr % (r-1);
								if(nr == 0) {
									cnt--;
									nr = r - 1;
								}
								// 홀수일 경우는 방향이 같은 상태	=> 상어의 위치는 행에서 loc을 빼야 함(상어의 방향이 아래에서 위로 향하고 있는 상태이므로)
								if(cnt % 2 == 1) {
									nr = (r - 1) - nr;
								}
								// 짝수일 경우에는 상태가 반대가 됨
								else {
									shark[sharkNum][3] = 1;
								}
								
								break;
							case 1:
								nr = nr - sharkInfo[0] - ((r - 1) - sharkInfo[0]);	// 제일 아랫칸 기준
								
								cnt = nr / (r-1);
								nr = nr % (r-1);
								if(nr == 0) {
									cnt--;
									nr = r - 1;
								}
								
								if(cnt % 2 == 0) {
									shark[sharkNum][3] = 0;
									nr = (r - 1) - nr;
								}
								
								break;
							case 2:
								nc = nc - sharkInfo[1] - ((c - 1) - sharkInfo[1]);	// 제일 오른쪽칸 기준
								
								cnt = nc / (c-1);
								nc = nc % (c-1);
								if(nc == 0) {
									cnt--;
									nc = c - 1;
								}
								
								if(cnt % 2 == 0) {
									shark[sharkNum][3] = 3;
									nc = (c - 1) - nc;
								}
								
								break;
							case 3:
								nc = Math.abs(nc);	// 제일 왼쪽칸 기준
								
								cnt = nc / (c-1);
								nc = nc % (c-1);
								if(nc == 0) {
									cnt--;
									nc = c - 1;
								}

								if(cnt % 2 == 1) {
									nc = (c - 1) - nc;
								}
								else {
									shark[sharkNum][3] = 2;
								}

								break;
							}
						}
						
						// 다른 상어가 있다면
						if(copyMap[nr][nc] != 0) {
							if(shark[copyMap[nr][nc] - 1][4] > sharkInfo[4]) continue;
						}
						copyMap[nr][nc] = map[i][j];
						shark[sharkNum][0] = nr;
						shark[sharkNum][1] = nc;
					}
				}
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					map[i][j] = copyMap[i][j];
				}
			}
		}
		System.out.println(size);
	}
}
