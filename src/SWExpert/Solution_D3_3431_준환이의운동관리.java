package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3431_준환이의운동관리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int l = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			sb.append("#" + t + " ");
			if(x > u) sb.append("-1");
			else if(x >= l) sb.append("0");
			else sb.append(l - x);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
