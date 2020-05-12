package algorithm;

import java.util.Scanner;

public class FloydWarshall {
	static final int INF = 999999999;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				D[i][j] = sc.nextInt();
				if(i != j && D[i][j] == 0) {	// 자기 자신으로의 인접이 아니고 갈 수 없다면
					D[i][j] = INF;
				}
			}
		}
		
		for(int k=0; k<N; k++) {			// 경유지
			for(int i=0; i<N; i++) {		// 출발지
				if(i == k) continue;				// 경유지와 출발지가 같다면 패스
				for(int j=0; j<N; j++) {	// 도착지
					if(j == k || i == j) continue;	// 경유지와 도착지가 같거나 출발지와 도착지가 같다면 패스
					if(D[i][k] + D[k][j] < D[i][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		System.out.println();
	}
}
