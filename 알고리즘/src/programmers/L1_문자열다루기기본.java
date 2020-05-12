package programmers;

public class L1_문자열다루기기본 {
	public static void main(String[] args) {
		String s = "1a34b";
		boolean answer = true;
		
		char c[] = s.toCharArray();
		
		if(c.length != 4 && c.length != 6) answer = false;
		
		for(char ch : c) {
			try {
				Integer.parseInt(Character.toString(ch));
			} catch(NumberFormatException e) {
				answer = false;
			}
		}
		
		System.out.println(answer);
	}
}
