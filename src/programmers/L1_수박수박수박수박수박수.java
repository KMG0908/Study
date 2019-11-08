package programmers;

public class L1_수박수박수박수박수박수 {
	public static void main(String[] args) {
		int n = 3;
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			if(i%2==0) answer += "��";
			else answer += "��";
		}
		
		System.out.println(answer);
	}
}
