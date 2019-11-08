package programmers;

import java.util.ArrayList;

public class L1_약수의합 {
	public static void main(String[] args) {
		int n = 12;
		int answer = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(n % i == 0) list.add(i);
		}
		
		for(int i=0; i<list.size(); i++) {
			answer += list.get(i);
		}
	}
}
