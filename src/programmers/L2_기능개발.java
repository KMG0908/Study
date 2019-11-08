package programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class L2_기능개발 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = {};
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<progresses.length; i++) {
			list.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
		}
		
		for(int i=0; i<list.size(); i++) {
			for(int j=i-1; j>=0; j--) {
				if(list.get(i) < list.get(j)) {
					list.set(i, list.get(j));
				}
			}
		}
		
		HashSet<Integer> hash = new HashSet();
		hash.addAll(list);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.addAll(hash);
		
		answer = new int[list2.size()];
		
		int index = 0;
		
		answer[index] = 1;
		for(int i=1; i<list.size(); i++) {
			if(list.get(i) == list.get(i-1)) answer[index]++;
			else answer[++index]++;
		}
		
		for(int i=0; i<answer.length; i++) System.out.println(answer[i]);
	}
}
