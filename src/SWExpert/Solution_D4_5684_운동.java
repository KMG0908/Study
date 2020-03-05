package SWExpert;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_5684_운동 {
	public static int n, m, distance[][];
	public static final int INF = 999999999;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			n = sc.nextInt();
			m = sc.nextInt();
			
			distance = new int[n+1][n+1];
			
			for(int i=1; i<=n; i++){
				Arrays.fill(distance[i], INF);
			}
			
			for(int i=0; i<m; i++){
				int s = sc.nextInt();
				int e = sc.nextInt();
				int c = sc.nextInt();
				
				distance[s][e] = c;
			}
			
			sb.append("#" + t + " " + floydWarshall() + "\n");
		}

		System.out.println(sb.toString());
	}
	
	public static int floydWarshall(){
		for(int k=1; k<=n; k++) {			// 경유지
			for(int i=1; i<=n; i++) {		// 출발지
				if(i == k) continue;		// 경유지와 출발지가 같다면 패스
				for(int j=1; j<=n; j++) {	// 도착지
					if(j == k) continue;	// 경유지와 도착지가 같다면 패스
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		
		int ans = INF;
		
		for(int i=1; i<=n; i++){
			ans = Math.min(ans, distance[i][i]);
		}
		
		return ans == INF? -1 : ans;
	}
}
