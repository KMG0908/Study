package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while(true) {
			int cnt = getCount(n + ans);
			if(cnt <= k) break;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int getCount(int num) {
		int cnt = 0;
		
		while(num > 0) {
			if(num % 2 == 1) cnt++;
			num /= 2;
		}
		
		return cnt;
	}
}
