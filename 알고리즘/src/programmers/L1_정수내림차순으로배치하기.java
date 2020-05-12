package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class L1_정수내림차순으로배치하기 {
	public static void main(String[] args) {
		long n = 118372;
		long answer = 0;
		
		char[] c = String.valueOf(n).toCharArray();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<c.length; i++) {
			list.add(Integer.parseInt(Character.toString(c[i])));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		String str = "";
		for(int i=0; i<list.size(); i++) {
			str += list.get(i);
		}
		
		answer = Long.parseLong(str);
		
		System.out.println(answer);
	}
}
