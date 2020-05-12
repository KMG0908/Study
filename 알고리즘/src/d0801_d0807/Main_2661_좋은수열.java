package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://mygumi.tistory.com/213 참고... 풀이 보면 알겠는데 왜 코드는 짜지 못하는가...
public class Main_2661_좋은수열 {
	static int n;
	static boolean stop = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dfs(1, "1");
	}
	
	public static void dfs(int len, String s) {
		if(stop) return;
		
		if(n == len) {
			stop = true;
			System.out.println(s);
		}
		else {
			for(int i=1; i<=3; i++) {
				if(isGood(s + i)) {
					dfs(len + 1, s + i);
				}
			}
		}
	}

	private static boolean isGood(String s) {
		int len = s.length();
		int loop = len / 2;
		int start = len - 1;
		int end = len;
		
		for(int i=1; i<=loop; i++) {
			if(s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start--;
		}
		
		return true;
	}
}
