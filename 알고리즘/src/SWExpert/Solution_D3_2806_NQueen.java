package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen {
	public static int n, board[], res = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++){
			n = Integer.parseInt(br.readLine());
			board = new int[n];	// 같은 행에 놓는 것은 어차피 불가능
			res = 0;
			
			queen(0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	public static void queen(int row){
		if(row == n){
			res++;
		}
		else{
			for(int i=0; i<n; i++){
				boolean flag = true;
				for(int j=0; j<row; j++){
					// 같은 열에 있거나 대각선에 위치하고 있을 경우
					if(i == board[j] || Math.abs(row - j) == Math.abs(i - board[j])){
						flag = false;
						break;
					}
				}
				
				if(flag){
					board[row] = i;
					queen(row + 1);
				}
			}
		}
	}
}

