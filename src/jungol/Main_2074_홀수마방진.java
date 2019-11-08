package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2074_홀수마방진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int size = n * n;
		
		int i = 0;
		int j = n / 2;
		
		int num = 0;
		
		while(num != size) {
			map[i][j] = ++num;
			
			if(map[i][j] % n == 0) {
				i++;
			}
			else {
				i--;
				j--;
				if(i < 0) i = n -1;
				if(j < 0) j = n - 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int a=0; a<n; a++) {
			for(int b=0; b<n; b++) {
				sb.append(map[a][b] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
