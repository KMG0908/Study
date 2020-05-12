package programmers;

public class L1_자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		long n = 12345;
		int[] answer = {};
		
		char[] c = String.valueOf(n).toCharArray();
		answer = new int[c.length];
		
		int index = 0;
		for(int i=c.length-1; i>=0; i--) {
			answer[index++] += Integer.parseInt(Character.toString(c[i]));
		}
	}
}
