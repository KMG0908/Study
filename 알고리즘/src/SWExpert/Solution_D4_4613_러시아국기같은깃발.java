package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_4613_러시아국기같은깃발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[n][m];
			int[][] color = new int[n][3];
			
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
				
				for(int j=0; j<m; j++) {
					switch(map[i][j]) {
					case 'W':
						color[i][0]++;
						break;
					case 'B':
						color[i][1]++;
						break;
					case 'R':
						color[i][2]++;
						break;
					}
				}
			}
			
			int white = 1, blue = 1, red = n - 2;
			int min = Integer.MAX_VALUE;
			
			while(true) {
				int change_w = 0, change_b = 0, change_r = 0;
				
				for(int i=0; i<white; i++) {
					change_w += color[i][1] + color[i][2];
				}
				
				for(int i=white; i<white+blue; i++) {
					change_b += color[i][0] + color[i][2];
				}
				
				for(int i=white+blue; i<white+blue+red; i++) {
					change_r += color[i][0] + color[i][1];
				}
				
				if(red - 1 > 0) {
					blue++;
					red--;
				}
				else {
					white++;
					blue = 1;
					red = n - white - blue; 
				}
				
				min = Math.min(min, change_w + change_b + change_r);
				
				if(white == n - 1) break;
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
}
