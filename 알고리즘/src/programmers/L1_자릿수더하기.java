package programmers;

public class L1_자릿수더하기 {
	public static void main(String[] args) {
		int n = 123;
		int answer = 0;
		
		int length = String.valueOf(n).length();
		
		int start = 1;
		
		for(int i=1; i<length; i++) {
			start *= 10;
		}
		
		for(int i=0; i<length; i++) {
			answer += n/start;
			n %= start;
			start /= 10;
		}
		
		System.out.println(answer);
	}
}
