package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	public static int n, m;
	public static char board[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int res = Integer.MAX_VALUE;
		// 시작점을 기준으로 8 * 8 크기의 체스판을 만들 수 있을 경우에만
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				res = Math.min(res, reprint(i, j));
			}
		}
		
		System.out.println(res);
	}
	
	public static int reprint(int x, int y) {
		char ch = board[x][y];
		int cnt = 0;
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(i == x && j == y) continue;
				
				// 전의 것이 이번 것과 같다면 새로 칠해야 하는 부분임
				if(ch == board[i][j]) {
					cnt++;
					if(ch == 'B') ch ='W';
					else ch = 'B';
				}
				else ch = board[i][j];
			}
			
			// 줄이 바뀌었을 경우에는 전의 것이 이번 것의 색깔과 동일해야 하므로 변경
			if(ch == 'B') ch ='W';
			else ch = 'B';
		}
		
		// 시작점을 기준으로 색깔을 맞추는 경우보다 시작점을 새로 칠하고 그거에 맞추는 경우가 더 최소일 경우도 있을 수 있음
		return Math.min(cnt, 64 - cnt);
	}
}
