package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	public static int n, m, c;
	public static int[][] map, maxMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			maxMap = new int[n][n];
			
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1. 각 i, j 위치에서 연속된 m개를 고려하여 취할 수 있는 부분집합의 최대 이익 계산
			makeMaxMap();
			
			// 2. 두 일꾼의 조합
			sb.append("#" + t + " " + getMaxBenefit() + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void makeMaxMap(){
		for(int i=0; i<n; i++){
			for(int j=0; j<=n-m; j++){
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	
	// i: 행 위치, j: 열 위치, cnt: 고려한 원소 수
	// sum: 부분집합에 속한 원소의 합, powSum: 부분집합에 속한 원소의 이익
	public static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum){
		if(sum > c) return;	// 부분집합의 합이 목표량 c를 초과하면 리턴
		if(cnt == m){
			if(maxMap[i][j - m] < powSum){
				maxMap[i][j - m] = powSum;
			}
			
			return;
		}
		
		// i, j 위치 원소 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
		
		// i, j 위치 원소 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}
	
	public static int getMaxBenefit(){
		int max = 0, temp = 0;	// max: 조합적 선택 후의 최대 이익 값
		// 1. 일꾼 A 기준 선택
		for(int i=0; i<n; i++){
			for(int j=0; j<=n-m; j++){	// A 일꾼
				// 2. 일꾼 B 선택
				// 같은 행 기준 선택
				for(int j2=j+m; j2<=n-m; j2++){
					temp = maxMap[i][j] + maxMap[i][j2];	// 두 일꾼 조합의 최대 이익
					max = Math.max(max, temp);
				}
				
				// 다음 행부터 마지막 행까지 선택
				for(int i2=i+1; i2<n; i2++){
					for(int j2=0; j2<=n-m; j2++){
						temp = maxMap[i][j] + maxMap[i2][j2];
						max = Math.max(max, temp);
					}
				}
			}
		}
		
		return max;
	}
}
