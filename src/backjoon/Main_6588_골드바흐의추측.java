package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588_골드바흐의추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] not_prime = new boolean[1000000];
		not_prime[1] = true;
		
		for(int i=2; i<500000; i++) {
			for(int j=i*2; j<1000000; j+=i) {
				not_prime[j] = true;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		next:
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			for(int i=2; i<500000; i++) {
				if(!not_prime[i] && !not_prime[n - i]) {
					sb.append(n + " = " + i + " + " + (n - i) + "\n");
					continue next;
				}
			}
			
			sb.append("Goldbach's conjecture is wrong.\n");
		}
		
		System.out.println(sb.toString());
	}
}
