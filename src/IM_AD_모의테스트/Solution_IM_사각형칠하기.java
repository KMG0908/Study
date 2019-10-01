package IM_AD_모의테스트;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_IM_사각형칠하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] rectangle = new int[n][m];
			
			ing:
			for(int c=0; c<k; c++) {
				st = new StringTokenizer(br.readLine(), " ");
				int startX = Integer.parseInt(st.nextToken());
				int startY = Integer.parseInt(st.nextToken());
				int endX = Integer.parseInt(st.nextToken());
				int endY = Integer.parseInt(st.nextToken());
				int number = Integer.parseInt(st.nextToken());
				
				for(int i=startX; i<=endX; i++) {
					for(int j=startY; j<=endY; j++) {
						if(rectangle[i][j] > number) continue ing;
					}
				}
				
				for(int i=startX; i<=endX; i++) {
					for(int j=startY; j<=endY; j++) {
						rectangle[i][j] = number;
					}
				}
			}
			
			int[] size = new int[11];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					size[rectangle[i][j]]++;
				}
			}
			
			Arrays.sort(size);
			
			System.out.println("#" + t + " " + size[10]);
		}
	}
}
