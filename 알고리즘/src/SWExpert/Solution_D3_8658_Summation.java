package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8658_Summation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<10; i++){
				int num = Integer.parseInt(st.nextToken());
				int sum = 0;
				
				while(num > 0){
					sum += num % 10;
					num = num / 10;
				}
				
				min = Math.min(min, sum);
				max = Math.max(max, sum);
			}
			
			sb.append("#" + t + " " + max + " " + min + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
