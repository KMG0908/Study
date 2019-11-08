package programmers;

import java.util.ArrayList;

public class L1_이상한문자만들기 {
	public static void main(String[] args) {
		String s = "  try hello  world strys try t   ";
		String answer = "";
		
		String s_trim = s.trim();
		int space = s.length() - s_trim.length();
		
		String[] str = s.split("\\s");
		
		for(int i=0; i<str.length; i++) {
			if(str[i].equals("") && answer.trim().equals("")) space--;
			char[] c = str[i].toCharArray();
			
			for(int j=0; j<c.length; j++) {
				if((c[j] >= 'a' && c[j] <= 'z') || c[j] >= 'A' && c[j] <= 'Z') {
					if(j % 2 == 0) answer += Character.toString(c[j]).toUpperCase();
					else answer += Character.toString(c[j]).toLowerCase();
				}
				
				/*if(j % 2 == 0) {
					if(c[j] >= 'a' && c[j] <= 'z') {
						answer += (char)(c[j] - ('a' - 'A'));
					}
					else answer += c[j];
				}
				else {
					if(c[j] >= 'A' && c[j] <= 'Z') {
						answer += (char)(c[j] + ('a' - 'A'));
					}
					else answer += c[j];
				}*/
			}
			
			if(i != str.length - 1) answer += " ";
			else {
				if(space != 0) {
					for(int k=0; k<space; k++) answer += " ";
				}
			}
		}
		
		System.out.println(answer);
	}
}
