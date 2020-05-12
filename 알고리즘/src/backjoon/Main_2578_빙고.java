package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	public static int[] loc;
	public static int[][] number;
	public static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		loc = new int[26];
		check = new boolean[5][5];
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				loc[num] = i * 5 + j;
			}
		}
		
		number = new int[5][5];
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				number[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(isBingo(number[i][j])) {
					System.out.println(i * 5 + j + 1);
					System.exit(0);
				}
			}
		}
	}
	
	public static boolean isBingo(int number) {
		check[loc[number] / 5][loc[number] % 5] = true;
		
		int bingo = 0;
		
		ing:
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(!check[i][j]) continue ing;
			}
			
			bingo++;
		}
		
		ing:
		for(int j=0; j<5; j++) {
			for(int i=0; i<5; i++) {
				if(!check[i][j]) continue ing;
			}
			
			bingo++;
		}
		
		if(check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) bingo++;
		if(check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) bingo++;
		
		if(bingo >= 3) return true;
		else return false;
	}
}
