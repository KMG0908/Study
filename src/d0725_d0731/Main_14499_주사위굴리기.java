package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		int diceX = Integer.parseInt(st.nextToken());
		int diceY = Integer.parseInt(st.nextToken());
		
		int o = Integer.parseInt(st.nextToken());
		int[] order = new int[o];
		
		int[][] dir = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<o; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dice = new int[6];
		
		/*
		 *     2
		 *   4 1 3
		 *     5
		 *     6
		 *  세로: 1 2 6 5
		 *  인덱스: 0 1 5 4
		 *  
		 *  가로: 1 3 6 4
		 *  인덱스: 0 2 5 3
		 */
		
		int nr, nc;
		
		for(int i=0; i<o; i++) {
			nr = diceX + dir[order[i] - 1][0];
			nc = diceY + dir[order[i] - 1][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			int temp = dice[0];
			switch(order[i]) {
			case 1:	// 동쪽
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = temp;
				diceX = nr;
				diceY = nc;
				break;
			case 2:	// 서쪽
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = temp;
				diceX = nr;
				diceY = nc;
				break;
			case 3:	// 북쪽
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = temp;
				diceX = nr;
				diceY = nc;
				break;
			case 4:	// 남쪽
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = temp;
				diceX = nr;
				diceY = nc;
				break;
			}
			
			if(map[diceX][diceY] == 0) map[diceX][diceY] = dice[5];
			else {
				dice[5] = map[diceX][diceY];
				map[diceX][diceY] = 0;
			}
			
			System.out.println(dice[0]);
		}
	}
}
