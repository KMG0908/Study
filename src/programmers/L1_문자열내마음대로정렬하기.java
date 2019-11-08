package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class L1_문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 1;
		
		String[] answer = strings;
		
		Arrays.sort(answer, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.substring(n, n + 1).compareTo(o2.substring(n, n+1)) == 0) return o1.compareTo(o2);
				else return o1.substring(n, n + 1).compareTo(o2.substring(n, n+1));
			}
		});
		
		for(int i=0; i<answer.length; i++) System.out.println(answer[i]);
	}
}
