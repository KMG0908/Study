package d0815_d0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참고: https://6a68.tistory.com/15
public class Main_5557_1학년 {
	public static int n, number[];
	public static char combi[], oper[] = {'+', '-'};
	public static boolean visited[];
	public static long result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		combi = new char[n-2];
		visited = new boolean[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i][j]: i번째 수까지 계산했을 때 j를 만들 수 있는 경우의 수
		long dp[][] = new long[n][21];
		
		dp[0][number[0]] = 1;
		
		/*System.out.println("i: 0 " + Arrays.toString(dp[0]));
		System.out.println();*/
		
		for(int i=1; i<n-1; i++) {
			for(int j=0; j<=20; j++) {
				// 전의 숫자까지 연산한 값이 j와 같은 경우가 존재하면
				if(dp[i-1][j] != 0) {
					// 전의 숫자까지 연산한 값 - 현재 숫자 => 음수가 아닐 경우
					if(j - number[i] >= 0) {
						// 현재 숫자까지 연산했을 때 j - number[i]를 만들 수 있는 경우는 전의 숫자까지 연산했을 때 j를 만들 수 있는 경우를 더해줌
						// j - number[i]가 나오는 경우는 하나가 아니므로 더해줘야 함
						dp[i][j - number[i]] += dp[i-1][j];
					}
					
					// 전의 숫자까지 연산한 값 + 현새 숫자 => 20을 넘어가지 않을 경우
					if(j + number[i] <= 20){
						dp[i][j + number[i]] += dp[i-1][j];
					}
				}
			}
			/*System.out.println("i: " + i + " " + Arrays.toString(dp[i]));
			System.out.println();*/
		}
		
		System.out.println(dp[n-2][number[n-1]]);
	}
}
