package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5549_홀수일까짝수일까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			String str = br.readLine();
			
			int last = str.charAt(str.length() - 1) - '0';
			
			sb.append("#" + t + " ");
			if(last % 2 == 0) sb.append("Even");
			else sb.append("Odd");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
