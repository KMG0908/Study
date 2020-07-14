package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032_명령프롬프트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		int len = str[0].length();
		
		for(int i=0; i<len; i++) {
			char ch = str[0].charAt(i);
			boolean isSame = true;
			
			for(int j=1; j<n; j++) {
				if(ch != str[j].charAt(i)) {
					isSame = false;
					break;
				}
			}
			
			if(isSame) sb.append(ch);
			else sb.append("?");
		}
		
		System.out.println(sb.toString());
	}
}
