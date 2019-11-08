package programmers;

public class L1_콜라츠추측 {
	public static void main(String[] args) {
		int num = 626331;
		int answer = 0;
		
		long n = (long)num;
		while(n != 1) {
			if(n % 2 == 0) n /= 2;
			else n = n * 3 + 1;

			answer++;
			
			if(answer == 500) {
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
