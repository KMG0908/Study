package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2303_숫자게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int number[][] = new int[n][5];
		int answer[] = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<5; j++) {
				number[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for(int l=0; l<n; l++) {
			for(int i=0; i<3; i++) {
				for(int j=i+1; j<4; j++) {
					for(int k=j+1; k<5; k++) {
						answer[l] = Math.max(answer[l], (number[l][i] + number[l][j] + number[l][k]) % 10);
					}
				}
			}
			
			max = Math.max(max, answer[l]);
		}
		
		int idx = 0;
		for(int i=0; i<n; i++) {
			if(max == answer[i]) idx = i;
		}
		
		System.out.println(idx + 1);
	}
}
