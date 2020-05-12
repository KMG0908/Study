package programmers;

import java.util.ArrayList;

public class L2_다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		int answer = 1;
		
		ArrayList<Integer> ed = new ArrayList<>();
		ArrayList<Integer> ing = new ArrayList<>();
		ArrayList<Integer> len = new ArrayList<>();
		
		int index = 0;
		
		while(true) {
			if(ed.size() == truck_weights.length) break;
			
			int sum = 0;
			
			for(int i=0; i<ing.size(); i++) {
				sum += ing.get(i);
			}
			
			if(index != truck_weights.length) {
				if(sum + truck_weights[index] <= weight) {
					ing.add(truck_weights[index++]);
					len.add(0);
				}
			}
			
			for(int i=0; i<len.size(); i++) {
				len.set(i, len.get(i) + 1);
			}
			
			for(int i=len.size()-1; i>=0; i--) {
				if(len.get(i) == bridge_length) {
					ed.add(ing.get(i));
					len.remove(i);
					ing.remove(i);
				}
			}
			
			answer++;
		}
		
		System.out.println(answer);
	}
}
