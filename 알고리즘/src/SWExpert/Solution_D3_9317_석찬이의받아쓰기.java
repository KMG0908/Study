package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_9317_석찬이의받아쓰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			int n = Integer.parseInt(br.readLine());
			
			char[] hear = new char[n];
			char[] write = new char[n];
			
			hear = br.readLine().toCharArray();
			write = br.readLine().toCharArray();
			
			int cnt = 0;
			for(int i=0; i<n; i++){
				if(hear[i] == write[i]) cnt++;
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
