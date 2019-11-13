package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[n];
		
		for(int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		
		int[] eat = new int[d + 1];
		int cnt = 0;
		boolean use = false;
		
		for(int i=0; i<k; i++) {
			if(eat[sushi[i]] == 0) {
				cnt++;
			}
			
			eat[sushi[i]]++;
		}
		
		for(int i=1; i<=n; i++) {
			// 쿠폰을 사용했을 경우
			if(use) {
				cnt--;
				use = false;
			}
			
			// 전에 먹은 초밥 빼주기
			eat[sushi[i - 1]]--;
			// 뺀 초밥이 먹은 초밥의 종류에 없을 경우 cnt--
			if(eat[sushi[i - 1]] == 0) cnt--;
			
			// 넣을 초밥이 먹은 초밥의 종류에 없을 경우 cnt++
			if(eat[sushi[(i + k - 1) % n]] == 0) cnt++;
			eat[sushi[(i + k - 1) % n]]++;
			
			// 쿠폰 초밥을 먹지 않았을 경우에는 쿠폰을 사용하여 초밥 먹기
			if(eat[c] == 0) {
				cnt++;
				use = true;
			}
			
			ans = Math.min(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
