package programmers;

public class L1_정수제곱근판별 {
	public static void main(String[] args) {
		long n = 3;
		long answer = 0;
		
		answer = (long) Math.sqrt(n);
		
		if(Math.pow(answer, 2) == n) answer = (long) Math.pow(answer + 1, 2);
		else answer = -1;
		
		System.out.println(answer);
	}
}
