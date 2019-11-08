package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	public static boolean visited[];
	public static HashMap<Integer, ArrayList<Integer>> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		map = new HashMap<>();
		
		for(int i=0; i<n+1; i++) {
			map.put(i, new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		int count = 0;
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				count++;
				bfs(i);
			}
		}
		
		System.out.println(count);
	}
	
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			int info = queue.poll();
			ArrayList<Integer> tmp = map.get(info);
			
			for(int t : tmp) {
				if(!visited[t]) {
					queue.offer(t);
					visited[t] = true;
				}
			}
		}
	}
}
