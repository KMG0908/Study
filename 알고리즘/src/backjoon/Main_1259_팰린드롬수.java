package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0")) break;
			
			int len = str.length() / 2;
			int last = str.length() - 1;
			boolean flag = true;
			
			for(int i=0; i<len; i++) {
				if(str.charAt(i) != str.charAt(last - i)) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb.toString());
	}
}
