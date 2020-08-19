package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1284_집주소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0")) break;
			
			int res = 0;
			for(int i=0; i<str.length(); i++) {
				switch(str.charAt(i)) {
				case '0':
					res += 4;
					break;
				case '1':
					res += 2;
					break;
				default:
					res += 3;
					break;
				}
				res++;
			}
			
			res++;
			sb.append(res + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
