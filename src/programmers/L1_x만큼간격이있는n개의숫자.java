package programmers;

public class L1_x만큼간격이있는n개의숫자 {
	public static void main(String[] args) {
		int x = 2, n = 5;
		long[] answer = new long[n];
		
		long l = (long)x;
		
		for(int i=0; i<n; i++) {
			answer[i] = l + l * i;
		}
	}
}
