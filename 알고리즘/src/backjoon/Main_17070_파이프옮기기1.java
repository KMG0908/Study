package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	public static int n, map[][], cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 파이프 끝 지점에서
		move(0, 1, 0);
		System.out.println(cnt);
	}
	
	public static void move(int x, int y, int d) {
		if(x == n - 1 && y == n - 1) {
			cnt++;
		}
		else {
			switch(d) {
			case 0:
				if(right(x, y)) move(x, y + 1, 0);
				if(right_down(x, y)) move(x + 1, y + 1, 2);
				break;
			case 1:
				if(down(x, y)) move(x + 1, y, 1);
				if(right_down(x, y)) move(x + 1, y + 1, 2);
				break;
			case 2:
				if(right(x, y)) move(x, y + 1, 0);
				if(down(x, y)) move(x + 1, y, 1);
				if(right_down(x, y)) move(x + 1, y + 1, 2);
				break;
			}
		}
	}
	
	public static boolean right(int x, int y) {
		if(y + 1 < n) {
			if(map[x][y + 1] == 1) return false;
			
			return true;
		}
		
		return false;
	}
	
	public static boolean down(int x, int y) {
		if(x + 1 < n) {
			if(map[x + 1][y] == 1) return false;
			
			return true;
		}
		
		return false;
	}
	
	public static boolean right_down(int x, int y) {
		if(x + 1 < n && y + 1 < n) {
			if(map[x + 1][y] == 1) return false;
			if(map[x][y + 1] == 1) return false;
			if(map[x + 1][y + 1] == 1) return false;
			
			return true;
		}
		
		return false;
	}
}
