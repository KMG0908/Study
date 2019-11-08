package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	public static char[][] map;
	public static int h, w, streetcar[], dir[][] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			
			streetcar = new int[3];
			Arrays.fill(streetcar, -1);
			
			for(int i=0; i<h; i++) {
				map[i] = br.readLine().toCharArray();
				
				if(streetcar[0] == -1) {
					for(int j=0; j<w; j++) {
						if(map[i][j] == '^') {
							streetcar[0] = i;
							streetcar[1] = j;
							streetcar[2] = 0;
						}
						else if(map[i][j] == 'v') {
							streetcar[0] = i;
							streetcar[1] = j;
							streetcar[2] = 1;
						}
						else if(map[i][j] == '<') {
							streetcar[0] = i;
							streetcar[1] = j;
							streetcar[2] = 2;
						}
						else if(map[i][j] == '>') {
							streetcar[0] = i;
							streetcar[1] = j;
							streetcar[2] = 3;
						}
					}
					
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String oper = br.readLine();
			
			for(int k=0; k<n; k++) {
				switch(oper.charAt(k)) {
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			sb.append("#" + t + " ");
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void move(int direction) {
		streetcar[2] = direction;
		
		int nr, nc;
		nr = streetcar[0] + dir[direction][0];
		nc = streetcar[1] + dir[direction][1];
		
		switch(direction) {
		case 0:
			map[streetcar[0]][streetcar[1]] = '^';
			break;
		case 1:
			map[streetcar[0]][streetcar[1]] = 'v';
			break;
		case 2:
			map[streetcar[0]][streetcar[1]] = '<';
			break;
		case 3:
			map[streetcar[0]][streetcar[1]] = '>';
			break;
		}
		
		if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == '.') {
			map[nr][nc] = map[streetcar[0]][streetcar[1]];
			map[streetcar[0]][streetcar[1]] = '.';
			streetcar[0] = nr;
			streetcar[1] = nc;
		}
	}
	
	public static void shoot() {
		int nr = streetcar[0], nc = streetcar[1];
		
		while(true) {
			nr += dir[streetcar[2]][0];
			nc += dir[streetcar[2]][1];
			
			if(nr < 0 || nr >= h || nc < 0 || nc >= w) break;
			
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}
			else if(map[nr][nc] == '#') break;
		}
	}
}
