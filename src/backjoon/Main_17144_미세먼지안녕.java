package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[r][c];
		int air[] = new int[2];
		air[0] = -1;
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1 && air[0] == -1) {
					air[0] = i;
					air[1] = i+1;
				}
			}
		}
		
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		while(t > 0) {
			int dust[][] = new int[r][c];
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(room[i][j] == 0 || room[i][j] == -1) continue;
					
					int nr, nc, cnt = 0;
					
					for(int k=0; k<4; k++) {
						nr = i + dir[k][0];
						nc = j + dir[k][1];
						
						if(nr >= 0 && nr < r && nc >= 0 && nc < c && room[nr][nc] != -1) {
							cnt++;
							dust[nr][nc] += room[i][j] / 5;
						}
					}
					
					room[i][j] = room[i][j] - (room[i][j] / 5) * cnt;
				}
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					room[i][j] += dust[i][j];
				}
			}
			
			for(int i=air[0]-1; i>0; i--) {
				room[i][0] = room[i-1][0];
			}
			for(int j=0; j<c-1; j++) {
				room[0][j] = room[0][j+1];
			}
			for(int i=0; i<air[0]; i++) {
				room[i][c-1] = room[i+1][c-1];
			}
			for(int j=c-1; j>1; j--) {
				room[air[0]][j] = room[air[0]][j-1];
			}
			room[air[0]][1] = 0;
			
			for(int i=air[1]+1; i<r-1; i++) {
				room[i][0] = room[i+1][0];
			}
			for(int j=0; j<c-1; j++) {
				room[r-1][j] = room[r-1][j+1];
			}
			for(int i=r-1; i>air[1]; i--) {
				room[i][c-1] = room[i-1][c-1];
			}
			for(int j=c-1; j>1; j--) {
				room[air[1]][j] = room[air[1]][j-1];
			}
			room[air[1]][1] = 0;
			
			t--;
		}
		
		int res = 2;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				res += room[i][j];
			}
		}
		
		System.out.println(res);
	}
}
