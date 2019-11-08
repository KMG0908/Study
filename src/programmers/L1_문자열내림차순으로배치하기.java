package programmers;

import java.util.Arrays;

public class L1_문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String answer = "";
		
		char c[] = s.toCharArray();

		Arrays.sort(c);
		
		for(int i=c.length-1; i>=0; i--) answer += c[i];
		
		System.out.println(answer);
	}
}
