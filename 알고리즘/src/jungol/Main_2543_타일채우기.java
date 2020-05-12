package jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2543_타일채우기 {
	public static int n, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		fill(0, n - 1, 0, n - 1, x, y);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// hx, hy: 배수구 혹은 타일이 채워져 있는 위치
	public static void fill(int sx, int ex, int sy, int ey, int hx, int hy) {
		int mx = (sx + ex) / 2;
		int my = (sy + ey) / 2;
		
	    /*System.out.println(sx + " " + sy);
	    System.out.println(ex + " " + ey);
	    
	    for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	    System.out.println();*/
	    
	    if(hx >= sx && hx <= mx && hy >= sy && hy <= my) {
	    	map[mx][my + 1] = 1;
			map[mx + 1][my + 1] = 1;
			map[mx + 1][my] = 1;
			
			if(mx - sx != 0) {
				fill(sx, mx, sy, my, hx, hy);				// 왼쪽 위
				fill(sx, mx, my + 1, ey, mx, my + 1);		// 오른쪽 위
				fill(mx + 1, ex, sy, my, mx + 1, my);		// 왼쪽 아래
				fill(mx + 1, ex, my + 1, ey, mx + 1, my + 1);// 오른쪽 아래
			}
	    }
	    else if(hx >= mx + 1 && hx <= ex && hy >= sy && hy <= my) {
	    	map[mx][my] = 3;
	    	map[mx][my + 1] = 3;
	    	map[mx + 1][my + 1] = 3;
	    	
	    	if(mx - sx != 0) {
		    	fill(sx, mx, sy, my, mx, my);
				fill(sx, mx, my + 1, ey, mx, my + 1);
				fill(mx + 1, ex, sy, my, hx, hy);
				fill(mx + 1, ex, my + 1, ey, mx + 1, my + 1);
	    	}
	    }
	    else if(hx >= sx && hx <= mx && hy >= my + 1 && hy <= ey) {
	    	map[mx][my] = 2;
			map[mx + 1][my] = 2;
			map[mx + 1][my + 1] = 2;
			
			if(mx - sx != 0) {
				fill(sx, mx, sy, my, mx, my);
		    	fill(sx, mx, my + 1, ey, hx, hy);
				fill(mx + 1, ex, sy, my, mx + 1, my);
				fill(mx + 1, ex, my + 1, ey, mx + 1, my + 1);
			}
	    }
	    else if(hx >= mx + 1 && hx <= ex && hy >= my + 1 && hy <= ey) {
	    	map[mx][my] = 4;
	    	map[mx][my + 1] = 4;
	    	map[mx + 1][my] = 4;
	    	
	    	if(mx - sx != 0) {
		    	fill(sx, mx, sy, my, mx, my);
		    	fill(sx, mx, my + 1, ey, mx, my + 1);
				fill(mx + 1, ex, sy, my, mx + 1, my);
				fill(mx + 1, ex, my + 1, ey, hx, hy);
	    	}
	    }
	}
}
