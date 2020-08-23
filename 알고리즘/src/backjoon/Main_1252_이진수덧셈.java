package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1252_이진수덧셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int len = Math.max(a.length(), b.length());
		int diff = Math.abs(a.length() - b.length());
		
		if(a.length() > b.length()) {
			while(diff-- > 0) {
				b = "0" + b;
			}
		}
		else {
			while(diff-- > 0) {
				a = "0" + a;
			}
		}
		
		int flag = 0;
		String ans = "";
		for(int i=a.length()-1; i>=0; i--) {
			int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + flag;
			
			if(sum == 3) {
				ans = 1 + ans;
				flag = 1;
			}
			else if(sum == 2) {
				ans = 0 + ans;
				flag = 1;
			}
			else {
				ans = sum + ans;
				flag = 0;
			}
		}
		
		ans = flag == 1 ? flag + ans : ans;
		
		ans = ans.replaceAll("^0+", "");

        System.out.println(ans.equals("") ? 0 : ans);
	}
}
