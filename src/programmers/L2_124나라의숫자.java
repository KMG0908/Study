package programmers;

public class L2_124나라의숫자 {
	public static void main(String[] args) {
		int n = 4;
		String answer = "";
		
		int k = 0;
		
		while (n > 0) {
            k = n % 3; 
            n = n / 3;
            if (k == 0) {
                n = n-1; 
                k = 4;
            }
            answer = k + answer;
        }
		
		System.out.println(answer);
	}
}
