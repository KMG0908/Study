package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18238_ZOAC2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "A".concat(br.readLine());
		int ans = 0;
		
		for(int i=0; i<str.length()-1; i++) {
			int dif = Math.abs((str.charAt(i + 1) - 'A') - (str.charAt(i) - 'A'));
			ans += Math.min(dif, 26 - dif);
		}
		
		System.out.println(ans);
	}
}
