package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1978_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] not_prime = new boolean[1001];
		not_prime[1] = true;
		
		for(int i=2; i<500; i++) {
			for(int j=i*2; j<1001; j+=i) {
				not_prime[j] = true;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(!not_prime[Integer.parseInt(st.nextToken())]) cnt++;
		}

		System.out.println(cnt);
	}
}
