package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5601_쥬스나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append("#" + t + " ");
			for(int i=0; i<n; i++) {
				sb.append("1/" + n + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
