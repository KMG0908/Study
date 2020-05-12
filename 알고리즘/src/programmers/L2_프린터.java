package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L2_프린터 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		int answer = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> sequence = new LinkedList<>();
		
		for(int i=0; i<priorities.length; i++) {
			queue.add(priorities[i]);
			sequence.add(i);
		}
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			int flag = 0;
			for(int i=0; i<queue.size(); i++) {
				if(Integer.parseInt(queue.toArray()[i].toString()) > q) flag = 1;
			}
			
			if(flag == 1) {
				queue.add(q);
				sequence.add(sequence.poll());
			}
			else {
				cnt++;
				if(sequence.poll() == location) answer = cnt;
			}
			
		}
		
		System.out.println(answer);
	}
}
