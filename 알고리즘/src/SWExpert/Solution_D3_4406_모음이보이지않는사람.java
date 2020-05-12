package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_4406_모음이보이지않는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			String str = br.readLine().replaceAll("(a|e|i|o|u)", "");
			
			sb.append("#" + t + " " + str + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
