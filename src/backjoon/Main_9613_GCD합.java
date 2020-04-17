package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9613_GCD합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int[] num = new int[n];
			
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					sum += gcd(num[i], num[j]);
				}
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}
}
