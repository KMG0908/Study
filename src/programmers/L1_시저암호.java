package programmers;

public class L1_시저암호 {
	public static void main(String[] args) {
		String s = "a B z";
		int n = 4;
		
		String answer = "";
		
		char[] c = s.toCharArray();
		
		for(int i=0; i<c.length; i++) {
			if(c[i] >= 'a' && c[i] <= 'z'){
				if((char) (c[i] + n) > 'z') {
					answer += (char) (c[i] + n - ('z' - 'a' + 1));
				}
				else answer += (char) (c[i] + n);
			}
			else if(c[i] >= 'A' && c[i] <= 'Z'){
				if((char) (c[i] + n) > 'Z') {
					answer += (char) (c[i] + n - ('Z' - 'A' + 1));
				}
				else answer += (char) (c[i] + n);
			}
			else answer += c[i];
		}
		
		System.out.println(answer);
	}
}
