package programmers;

public class L1_하샤드수 {
	public static void main(String[] args) {
		int x = 11;
		boolean answer = true;
		
		int length = String.valueOf(x).length();
		
		int start = 1;
		
		for(int i=1; i<length; i++) {
			start *= 10;
		}
		
		int sum = 0;
		int n = x;
		
		for(int i=0; i<length; i++) {
			sum += n/start;
			n %= start;
			start /= 10;
		}
		
		if(x % sum != 0) answer = false;
		
		System.out.println(answer);
	}
}
