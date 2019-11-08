package programmers;

public class L1_가운데글자가져오기 {
	public static void main(String[] args) {
		String s = "abcde";
		
		String answer = "";
		
		if(s.length() % 2 == 0) answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		else answer = s.substring(s.length() / 2, s.length() / 2 + 1);
		
		System.out.println(answer);
	}
}
