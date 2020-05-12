package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		while(!queue.isEmpty()) {
			for(int i=1; i<k; i++) {
				queue.add(queue.peek());
				queue.poll();
			}
			
			if(queue.size() == 1) sb.append(queue.poll() + ">");
			else sb.append(queue.poll() + ", ");
		}
		
		System.out.println(sb.toString());
	}
}
