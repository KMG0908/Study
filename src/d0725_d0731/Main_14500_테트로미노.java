package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int numbers[];
	static int locations[][] = new int[36][3];
	static int idx = 0;
	
	public static void permutation(int index) {
		if(index == 3) {
			locations[idx++] = Arrays.copyOf(numbers, numbers.length);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(index == 0) {
				numbers[index] = i;
				permutation(index + 1);
			}
			else {
				if((i==0 && numbers[index-1]==1) || (i==1 && numbers[index-1]==0) 
						|| (i==2 && numbers[index-1]==3) || (i==3 && numbers[index-1]==2)) continue;
				
				numbers[index] = i;
				permutation(index + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] paper = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[3];
		permutation(0);
		
		int[][][] tetromino = { { {0, 1}, {1, 0}, {1, 1}, {1, 2} },
				{ {0, 0}, {0, 1}, {0, 2}, {1, 1} },
				{ {0, 0}, {1, 0}, {1, 1}, {2, 0} },
				{ {1, 0}, {0, 1}, {1, 1}, {2, 1} } };
		
		int max = 0;
		
		// ㅜ 모양을 제외한 모양은 전에 놓은 블록에서 다음 블록을 놓는 식으로 만들 수 있음
		// => 한 번에 연결이 가능 => 가능한 모든 조합을 일일이 대입해서 가장 큰 값 찾기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int cr, cc;
				int nr, nc;
				for(int l=0; l<locations.length; l++) {
					cr = i;
					cc = j;
					int sum = paper[cr][cc];
					out:
					for(int index=0; index<locations[l].length; index++) {
						switch(locations[l][index]) {
						case 0:			// 위
							nr = cr - 1;
							nc = cc;
							if(nr < 0) {
								sum = 0;
								break out;
							}
							sum += paper[nr][nc];
							cr = nr;
							cc = nc;
							break;
						case 1:			// 아래
							nr = cr + 1;
							nc = cc;
							if(nr >= n) {
								sum = 0;
								break out;
							}
							sum += paper[nr][nc];
							cr = nr;
							cc = nc;
							break;
						case 2:			// 왼쪽
							nr = cr;
							nc = cc - 1;
							if(nc < 0) {
								sum = 0;
								break out;
							}
							sum += paper[nr][nc];
							cr = nr;
							cc = nc;
							break;
						case 3:			// 오른쪽
							nr = cr;
							nc = cc + 1;
							if(nc >= m) {
								sum = 0;
								break out;
							}
							sum += paper[nr][nc];
							cr = nr;
							cc = nc;
							break;
						}
					}
					if(sum > max) max = sum;
				}
			}
		}
		
		// ㅜ 모양은 놓을 수 있는 위치를 직접 설정한 뒤 대입해서 찾아야 함
		for(int row=0; row<n; row++) {
			for(int col=0; col<m; col++) {
				int cr = row, cc = col;
				int nr, nc;
				for(int i=0; i<tetromino.length; i++) {
					int sum = 0;
					for(int j=0; j<tetromino[i].length; j++) {
						nr = cr + tetromino[i][j][0];
						nc = cc + tetromino[i][j][1];
						if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
							sum = 0;
							break;
						}
						sum += paper[nr][nc];
					}
					if(sum > max) max = sum;
				}
			}
		}
		
		System.out.println(max);
	}
}
