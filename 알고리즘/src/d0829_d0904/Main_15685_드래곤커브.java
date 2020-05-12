package d0829_d0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] dragon = new int[n][4];
		
		int[][] board = new int[101][101];
		
		int[][] dir = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			dragon[i][1] = Integer.parseInt(st.nextToken());
			dragon[i][0] = Integer.parseInt(st.nextToken());
			dragon[i][2] = Integer.parseInt(st.nextToken());
			dragon[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			int r = dragon[i][0];
			int c = dragon[i][1];
			
			board[r][c] = 1;
			r += dir[dragon[i][2]][0];
			c += dir[dragon[i][2]][1];
			board[r][c] = 1;
			
			ArrayList<Integer> dirList = new ArrayList<>();
			dirList.add(dragon[i][2]);
			
			for(int g=1; g<=dragon[i][3]; g++) {
				int size = dirList.size();
				
				// 끝점을 기준으로 시계 방향으로 회전한 것을 붙여야 하므로 끝에서부터
				for(int j=size-1; j>=0; j--) {
					int d = dirList.get(j) + 1;
					if(d > 3) d = 0;  
					
					r += dir[d][0];
					c += dir[d][1];
					
					board[r][c] = 1;
					
					dirList.add(d);
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(board[i][j] == 1 && board[i][j+1] == 1 && board[i+1][j] == 1 && board[i+1][j+1] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
