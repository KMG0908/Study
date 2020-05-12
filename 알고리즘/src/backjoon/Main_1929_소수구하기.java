package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] not_prime = new boolean[10000001];
		not_prime[1] = true;
		
		for(int i=2; i<5000000; i++) {
			for(int j=i*2; j<10000001; j+=i) {
				not_prime[j] = true;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringBuffer sb = new StringBuffer();
		for(int i=n; i<=m; i++) {
			if(!not_prime[i]) sb.append(i + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
