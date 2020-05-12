package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {
	public static HashSet<Integer>[] big, small;
	public static boolean visited[], contains[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		big = new HashSet[n+1];
		small = new HashSet[n+1];
		
		for(int i=1; i<=n; i++) {
			big[i] = new HashSet<>();
			small[i] = new HashSet<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			small[a].add(b);
			big[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			contains = new boolean[n+1];
			bfs_small(i);
			
			visited = new boolean[n+1];
			contains = new boolean[n+1];
			bfs_big(i);
		}
		
		int cnt = 0;
		int max = n / 2;
		for(int i=1; i<=n; i++) {
			if(small[i].size() > max || big[i].size() > max) cnt++;
		}
		
		System.out.println(cnt);
		
		/*System.out.println(max);
		for(int i=1; i<=n; i++) {
			System.out.println(i + ": " + small.get(i) + " " + big.get(i));
		}*/
	}
	
	public static void bfs_small(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		visited[index] = true;
		
		for(int tmp : small[index]) {
			contains[tmp] = true;
		}
		
		while(!queue.isEmpty()) {
			int info = queue.poll();
			
			for(int tmp : small[info]) {
				if(!visited[tmp]) {
					queue.offer(tmp);
					visited[tmp] = true;
					if(!contains[tmp]) {
						small[index].add(tmp);
						contains[tmp] = true;
					}
				}
			}
		}
	}
	
	public static void bfs_big(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		visited[index] = true;
		
		for(int tmp : big[index]) {
			contains[tmp] = true;
		}
		
		while(!queue.isEmpty()) {
			int info = queue.poll();
			
			for(int tmp : big[info]) {
				if(!visited[tmp]) {
					queue.offer(tmp);
					visited[tmp] = true;
					if(!contains[tmp]) {
						big[index].add(tmp);
						contains[tmp] = true;
					}
				}
			}
		}
	}
}
