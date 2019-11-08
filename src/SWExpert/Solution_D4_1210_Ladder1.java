package SWExpert;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] dir = { {-1, -1}, {-1, 1} }; 
		
		for(int t=0; t<10; t++) {
			int testCase = sc.nextInt();
			
			int[][] ladder = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			int currentRow, currentCol;			// 현재 위치
			int newRow, newCol;					// 이동할 위치
			int result = -1;	// 결과값 저장
			
			Find:
			for(int k=0; k<100; k++) {
				if(ladder[99][k] == 2) {
					currentRow = 99;
					currentCol = k;
					
					while(currentRow > 0) {
						Move:
						for(int i=0; i<dir.length; i++) {
							newRow = currentRow + dir[i][0];
							newCol = currentCol + dir[i][1];
							
							if(newRow >= 0 && newRow < 100 && newCol >= 0 && newCol < 100) {
								if(ladder[newRow][newCol] == 1) {
									if(dir[i][1] == -1) {		// 왼쪽 사선 위
										newRow = currentRow - 1;
										while(true) {
											newCol -= 1;
											if(newCol < 0 || ladder[newRow][newCol] == 0) {
												currentRow = newRow;
												currentCol = newCol + 1;
												break Move;
											}
										}
									}
									else{						// 오른쪽 사선 위
										newRow = currentRow - 1;
										while(true) {
											newCol += 1;
											if(newCol >= 100 || ladder[newRow][newCol] == 0) {
												currentRow = newRow;
												currentCol = newCol - 1;
												break Move;
											}
										}
									}
								}
							}
							
							if(i==dir.length - 1) {
								currentRow -= 1;	// 위로 이동
							}
						}
					
						
						if(currentRow == 0) {
							result = currentCol;
							break Find;
						}
					}
				}
			}
			
			System.out.println("#" + testCase + " " + result);
		}
	}
}
