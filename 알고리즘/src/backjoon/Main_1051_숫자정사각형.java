package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형 {
	public static int n, m, rect[][], max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rect = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				rect[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				max = Math.max(max, maxSquare(i, j));
			}
		}
		
		System.out.println(max);
	}
	
	public static int maxSquare(int x, int y) {
		int size = Math.min(n - x, m - y);
		if(size * size < max) return 0;
			
		int res = 1;
		
		for(int s=1; s<size; s++) {
			if(rect[x][y] == rect[x + s][y] && rect[x + s][y] == rect[x][y + s] &&
					rect[x][y + s] == rect[x + s][y + s]) res = Math.max(res, (s + 1) * (s + 1));
		}
		
		return res;
	}
}
