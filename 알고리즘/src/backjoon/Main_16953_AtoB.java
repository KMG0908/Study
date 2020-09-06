package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_AtoB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		
		HashSet<Integer> set = new HashSet<>();
		set.add(a);
		
		int cnt = 0;
		boolean flag = false;
		
		exit:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int info = queue.poll();
				
				if(info == b) {
					flag = true;
					break exit;
				}
				
				// (long) 안해주면 int 범위 벗어나서 안 끝남
				if((long)info * 10 + 1 <= 1000000000 && !set.contains(info * 10 + 1)) {
					queue.add(info * 10 + 1);
					set.add(info * 10 + 1);
				}
				
				if((long)info * 2 <= 1000000000 && !set.contains(info * 2)) {
					queue.add(info * 2);
					set.add(info * 2);
				}
			}
			
			cnt++;
		}
		
		if(flag) System.out.println(cnt + 1);
		else System.out.println("-1");
	}
}
