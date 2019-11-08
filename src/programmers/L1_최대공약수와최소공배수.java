package programmers;

public class L1_최대공약수와최소공배수 {
	public static void main(String[] args) {
		int n = 2, m = 5;
		int[] answer = new int[2];
		
		int r = 1;
		
		int temp1 = n, temp2 = m;
		if(temp1 < temp2) {
			int temp = temp1;
			temp1 = temp2;
			temp2 = temp;
		}
		
		while(r > 0) {
			r = temp1 % temp2;
			temp1 = temp2;
			temp2 = r;
		}
		
		answer[0] = temp1;
		answer[1] = n * m / temp1;
	}
}
