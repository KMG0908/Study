package d0815_d0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5569_출근경로 {
	public static int w, h;
	public static long cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int[][][][] dp = new int[101][101][2][2];
		
		/*
		 * 세번째 인자
		 * 0: 동쪽으로 이동
		 * 1: 북쪽으로 이동
		 * 
		 * 네번째 인자
		 * 0: 현재 방향으로 1칸 이동
		 * 1: 2칸 이상 이동
		 */
		for(int i=2; i<=w; i++) dp[i][1][0][0] = 1;
		for(int i=2; i<=h; i++) dp[1][i][1][0] = 1;
		
		for(int i=2; i<=w; i++) {
			for(int j=2; j<=h; j++) {
				// 동쪽으로 1칸 움직이는 경우 => 전에 동쪽으로 1칸 움직였던 경우와 동쪽으로 2칸 이상 움직였던 경우를 더해줌
				dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % 100000;
				// 동쪽으로 2칸 이상 움직이는 경우 => 전의 이동이 북쪽이었음 => 전에 북쪽으로 1칸 움직인 경우가 됨 
				dp[i][j][0][1] = dp[i-1][j][1][0];
				// 북쪽으로 1칸 움직이는 경우 => 전에 북쪽으로 1칸 움직였던 경우와 북쪽으로 2칸 이상 움직였던 경우를 더해줌
				dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % 100000;
				// 북쪽으로 2칸 이상 움직이는 경우 => 전의 이동이 동쪽이었음 => 전에 동쪽으로 1칸 움직인 경우가 됨
				dp[i][j][1][1] = dp[i][j-1][0][0];
			}
		}
		
		int res = 0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				res += dp[w][h][i][j];
			}
		}
		
		System.out.println(res % 100000);
	}
}
