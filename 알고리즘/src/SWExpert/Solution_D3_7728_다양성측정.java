package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7728_다양성측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			char[] ch = br.readLine().toCharArray();
			boolean[] visited = new boolean[10];
			
			int size = ch.length;
			
			for(int i=0; i<size; i++){
				visited[ch[i] - '0'] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<10; i++){
				if(visited[i]) cnt++;
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
