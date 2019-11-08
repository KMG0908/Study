package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	public static int n, map[][], white, blue;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		blue = 0;
		check(0, n, 0, n, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void check(int sx, int ex, int sy, int ey, int size) {
		int startX = sx;
		int endX = sx + size;
		int startY = sy;
		int endY = sy + size;
		
		while(true) {
			int one = 0, zero = 0;
			if(!visited[startX][startY]) {
				for(int i=startX; i<endX; i++) {
					for(int j=startY; j<endY; j++) {
						if(map[i][j] == 1) one++;
						else zero++;
					}
				}
			}
			
			// 잘라진 종이가 모두 하얀색 또는 파란색으로 칠해져 있을 경우
			if(zero == size * size || one == size * size) {
				if(zero == size * size) white++;
				if(one == size * size) blue++;
				
				for(int i=startX; i<endX; i++) {
					for(int j=startY; j<endY; j++) {
						visited[i][j] = true;
					}
				}
			}
			// 색종이 자르기
			else {
				check(startX, endX, startY, endY, size / 2);
			}
			
			if(endX == ex && endY == ey) break;
			
			if(endY == ey) {
				startX = endX;
				endX += size;
				startY = sy;
				endY = sy + size;
			}
			else {
				startY = endY;
				endY += size;
			}
		}
	}
}
