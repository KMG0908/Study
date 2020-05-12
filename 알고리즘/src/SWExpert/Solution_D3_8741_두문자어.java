package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8741_두문자어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			sb.append("#" + t + " ");
			for(int i=0; i<3; i++){
				sb.append(String.valueOf(st.nextToken().charAt(0)).toUpperCase());
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
