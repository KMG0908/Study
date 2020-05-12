package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2960_에라토스테네스의체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[n+1];
		
		int cnt = 0;
		int ans = 0;
		
		while(cnt < k) {
			int p = 0;
			for(int i=2; i<=n; i++) {
				if(!check[i]) {
					p = i;
					for(int j=p; j<=n & cnt<k; j+=p) {
						if(!check[j]) {
							check[j] = true;
							cnt++;
							ans = j;
						}
					}
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
