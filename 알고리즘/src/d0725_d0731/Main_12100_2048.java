package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100_2048 {
	static int numbers[];
	static int direction[][] = new int[1024][5];
	static int idx = 0;
	
	public static void permutation(int index) {
		if(index == 5) {
			direction[idx++] = Arrays.copyOf(numbers, numbers.length);
			return;
		}
		
		for(int i=0; i<4; i++) {
			numbers[index] = i;
			permutation(index + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		int[][] copyBoard = new int[n][n];		// 숫자를 직접 움직일 보드
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[5];
		
		permutation(0);
		
		int result = 0;
		
		for(int d=0; d<direction.length; d++) {
			for(int i=0; i<n; i++) {
				copyBoard[i] = Arrays.copyOf(board[i], n);
			}
			
			int count = 0;
			
			while(count < 5) {
				int index = direction[d][count];
				
				switch(index) {
				case 0:			// 위쪽
					for(int i=0; i<n-1; i++) {
						for(int j=0; j<n; j++) {
							if(copyBoard[i][j] == 0) {						// 위로 옮기기(사이에 0이 존재하지 않게)
								for(int k=i; k<n-1; k++) {
									int c = k;
									
									while(true) {
										if(c+1 >= n) break;
										
										if(copyBoard[++c][j] != 0) {
											copyBoard[k][j] = copyBoard[c][j];
											copyBoard[c][j] = 0;
											break;
										}
									}
								}
							}
						}
					}
					
					for(int i=0; i<n-1; i++) {
						for(int j=0; j<n; j++) {
							if(copyBoard[i][j] == copyBoard[i+1][j]) {		// 아래의 것과 같으면 합치고 나머지 한칸씩 끌어오기
								copyBoard[i][j] *= 2;
								copyBoard[i+1][j] = 0;
								
								for(int k=i+1; k<n-1; k++) {
									copyBoard[k][j] = copyBoard[k+1][j];
									copyBoard[k+1][j] = 0;
								}
							}
						}
					}
					
					break;
				case 1:			// 아래쪽
					for(int i=n-1; i>0; i--) {
						for(int j=0; j<n; j++) {
							if(copyBoard[i][j] == 0) {
								for(int k=i; k>0; k--) {
									int c = k;
									
									while(true) {
										if(c-1 < 0) break;
										
										if(copyBoard[--c][j] != 0) {
											copyBoard[k][j] = copyBoard[c][j];
											copyBoard[c][j] = 0;
											break;
										}
									}
								}
							}
						}
					}
					
					for(int i=n-1; i>0; i--) {
						for(int j=0; j<n; j++) {
							if(copyBoard[i][j] == copyBoard[i-1][j]) {
								copyBoard[i][j] *= 2;
								copyBoard[i-1][j] = 0;
								
								for(int k=i-1; k>0; k--) {
									copyBoard[k][j] = copyBoard[k-1][j];
									copyBoard[k-1][j] = 0;
								}
							}
						}	
					}
					
					break;
				case 2:			// 왼쪽
					for(int i=0; i<n; i++) {
						for(int j=0; j<n-1; j++) {
							if(copyBoard[i][j] == 0) {
								for(int k=j; k<n-1; k++) {
									int c = k;
									
									while(true) {
										if(c+1 >= n) break;
										
										if(copyBoard[i][++c] != 0) {
											copyBoard[i][k] = copyBoard[i][c];
											copyBoard[i][c] = 0;
											break;
										}
									}
								}
							}
						}
					}
					
					for(int i=0; i<n; i++) {
						for(int j=0; j<n-1; j++) {
							if(copyBoard[i][j] == copyBoard[i][j+1]) {
								copyBoard[i][j] *= 2;
								copyBoard[i][j+1] = 0;
								
								for(int k=j+1; k<n-1; k++) {
									copyBoard[i][k] = copyBoard[i][k+1];
									copyBoard[i][k+1] = 0;
								}
							}
						}
					}
					
					break;
				case 3:			// 오른쪽
					for(int i=0; i<n; i++) {
						for(int j=n-1; j>0; j--) {
							if(copyBoard[i][j] == 0) {
								for(int k=j; k>0; k--) {
									int c = k;
									
									while(true) {
										if(c-1 < 0) break;
										
										if(copyBoard[i][--c] != 0) {
											copyBoard[i][k] = copyBoard[i][c];
											copyBoard[i][c] = 0;
											break;
										}
									}
								}
							}
						}
					}
					
					for(int i=0; i<n; i++) {
						for(int j=n-1; j>0; j--) {
							if(copyBoard[i][j] == copyBoard[i][j-1]) {
								copyBoard[i][j] *= 2;
								copyBoard[i][j-1] = 0;
								
								for(int k=j-1; k>0; k--) {
									copyBoard[i][k] = copyBoard[i][k-1];
									copyBoard[i][k-1] = 0;
								}
							}
						}
					}
					
					break;
				}
				
				count++;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(copyBoard[i][j] > result) result = copyBoard[i][j];
				}
			}
		}
		
		System.out.println(result);
	}
}
