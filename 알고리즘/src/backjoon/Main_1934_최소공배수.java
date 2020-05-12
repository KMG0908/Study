package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			sb.append(lcm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int lcm(int a, int b) {
		int res = a * b;
		
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		
		res /= a;
		
		return res;
	}
}
