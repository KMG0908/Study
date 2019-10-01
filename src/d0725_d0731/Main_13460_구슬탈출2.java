package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int directions[][] = new int[1048576][10];
	static int idx = 0;
	static int numbers[];
	
	public static void permutation(int index) {
		if(index == 10) {
			directions[idx++] = Arrays.copyOf(numbers, numbers.length);
			return;
		}
		
		for(int i=0; i<4; i++) {
			numbers[index] = i;
			permutation(index + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	// 보드 세로 길이
		int m = Integer.parseInt(st.nextToken());	// 보드 가로 길이
		
		char[][] board = new char[n][m];
		char[][] copyBoard = new char[n][m];		// 구슬이 움직이는 보드
		
		int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		
		int[][] red = new int[1][2];		// 빨간 구슬 위치
		int[][] blue = new int[1][2];		// 파란 구슬 위치
		int[][] exit = new int[1][2];		// 구멍 위치
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'R') {
					red[0][0] = i;
					red[0][1] = j;
				}
				else if(board[i][j] == 'B') {
					blue[0][0] = i;
					blue[0][1] = j;
				}
				else if(board[i][j] == 'O') {
					exit[0][0] = i;
					exit[0][1] = j;
				}
			}
		}
		
		numbers = new int[10];
		permutation(0);
		
		int redR, redC;		// 빨간 구슬 현재 위치
		int blueR, blueC;	// 파란 구슬 현재 위치
		int nr, nc;			// 다음 이동 위치
		int count = 0;
		int result = 11;
		
		for(int d=0; d<directions.length; d++) {
			for(int i=0; i<n; i++) {
				copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
			}
			
			count = 0;
			
			redR = red[0][0];
			redC = red[0][1];
			
			blueR = blue[0][0];
			blueC = blue[0][1];
			
			boolean redSuccess = false;
			boolean blueSuccess = false;

			while(count < 10) {
				int index = directions[d][count];
				
				boolean flag = true;
				
				// 빨간 구슬과 파란 구슬 중에 먼저 이동해야 하는 것 결정
				if(index == 0 && redC==blueC && redR > blueR) flag = false;
				else if(index == 1 && redC==blueC && redR < blueR) flag = false;
				else if(index == 2 && redR==blueR && redC > blueC) flag = false;
				else if(index == 3 && redR==blueR && redC < blueC) flag = false;
				
				if(flag) {
					while(true) {	// 빨간 구슬 이동
						nr = redR + dir[index][0];
						nc = redC + dir[index][1];
						
						if(copyBoard[nr][nc] == 'O') {
							copyBoard[redR][redC] = '.';
							redSuccess = true;
							break;
						}
						else if(copyBoard[nr][nc] == '.') {
							copyBoard[nr][nc] = 'R';
							copyBoard[redR][redC] = '.';
							
							redR = nr;
							redC = nc;
						}
						else break;
					}
					
					while(true) {	// 파란 구슬 이동
						nr = blueR + dir[index][0];
						nc = blueC + dir[index][1];
						
						if(copyBoard[nr][nc] == 'O') {
							copyBoard[blueR][blueC] = '.';
							count = -1;
							blueSuccess = true;
							break;
						}
						else if(copyBoard[nr][nc] == '.') {
							copyBoard[nr][nc] = 'B';
							copyBoard[blueR][blueC] = '.';
							
							blueR = nr;
							blueC = nc;
						}
						else break;
					}
				}
				else {
					while(true) {	// 파란 구슬 이동
						nr = blueR + dir[index][0];
						nc = blueC + dir[index][1];
						
						if(copyBoard[nr][nc] == 'O') {
							copyBoard[blueR][blueC] = '.';
							count = -1;
							blueSuccess = true;
							break;
						}
						else if(copyBoard[nr][nc] == '.') {
							copyBoard[nr][nc] = 'B';
							copyBoard[blueR][blueC] = '.';
							
							blueR = nr;
							blueC = nc;
						}
						else break;
					}
					
					while(true) {	// 빨간 구슬 이동
						nr = redR + dir[index][0];
						nc = redC + dir[index][1];
						
						if(copyBoard[nr][nc] == 'O') {
							copyBoard[redR][redC] = '.';
							redSuccess = true;
							break;
						}
						else if(copyBoard[nr][nc] == '.') {
							copyBoard[nr][nc] = 'R';
							copyBoard[redR][redC] = '.';
							
							redR = nr;
							redC = nc;
						}
						else break;
					}
				}
				
				count++;

				if(redSuccess || blueSuccess) break;
			}
			
			// 10번 이내에 탈출 실패
			if(redSuccess == false && blueSuccess == false) count = -1;
			
			// 탈출 성공
			if(count > 0) {
				if(count < result) result = count;
			}
		}

		// 모든 케이스가 다 실패했을 경우
		if(result == 11) System.out.println("-1");
		else System.out.println(result);
	}
}
