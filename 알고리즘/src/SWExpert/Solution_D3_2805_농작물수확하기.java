package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String[] str = br.readLine().split("");
				for(int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int center = n / 2;
			
			int value = 0;
			
			for(int i=0; i<n; i++) {
				int num = n - Math.abs(center-i) * 2;	// 한 줄에서 수확할 수 있는 작물 수
				num -= num / 2;							// 가운데를 기준으로 옆으로 몇 칸 수확할 수 있는지
				for(int j=0; j<n; j++) {
					if(j > center - num && j < center + num) {
						value += board[i][j];
					}
				}
			}
			
			System.out.println("#" + t + " " + value);
		}
	}
}
