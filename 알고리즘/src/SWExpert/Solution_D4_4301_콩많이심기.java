package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4301_콩많이심기 {
	public static int n, m, cnt;
	public static boolean[][] bean;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			bean = new boolean[n][m];
			
			cnt = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(check(i, j)) {
						bean[i][j] = true;
					}
				}
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean check(int x, int y) {
		if(x - 2 >= 0 && bean[x - 2][y]) return false;
		if(x + 2 < n && bean[x + 2][y]) return false;
		if(y - 2 >= 0 && bean[x][y - 2]) return false;
		if(y + 2 < m && bean[x][y + 2]) return false;
		
		cnt++;
		return true;
	}
}
