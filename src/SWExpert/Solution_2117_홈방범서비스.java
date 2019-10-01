package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	public static int n, m, map[][];
	public static int max = 0, total_house = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			max = 0;
			total_house = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) total_house++;
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					benefit(i, j);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void benefit(int x, int y) {
		int area = 0;
		
		while(true) {
			int house = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 영역 안에 집이 있을 경우
					if(Math.abs(i - x) + Math.abs(j - y) <= area && map[i][j] == 1) {
						house++;
					}
				}
			}
			
			int price = house * m - ((area + 1) * (area + 1) + area * area);
			
			if(price >= 0) max = Math.max(max, house);
			
			area++;
			// 전체 집이 모두 영역 안에 포함되었는데 손해를 보게 된다면 break
			if(total_house * m - ((area + 1) * (area + 1) + area * area) < 0) break;
		}
	}
}
