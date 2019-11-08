package programmers;

public class L1_2016년 {
	public static void main(String[] args) {
		int a = 5, b = 24;
		
		String answer = "";
		
		int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int day = 0;
		
		for(int i=0; i<a-1; i++) {
			day += month[i];
		}
		
		day += b;
		
		answer = week[(day+4) % 7];
		
		System.out.println(answer);
	}
}
