package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	public static boolean[] visited;
	public static ArrayList<HashMap<Integer, Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		list = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			list.add(new HashMap<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).put(b, a);
			list.get(b).put(a, b);
		}
		
		int cnt = 0;
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				HashMap<Integer, Integer> tmp = list.get(i);
				for(int t : tmp.keySet()) {
					if(!visited[t]) {
						//dfs(t);
						bfs(t);
					}
				}
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		
		HashMap<Integer, Integer> tmp = list.get(index);
		for(int t : tmp.keySet()) {
			if(!visited[t]) dfs(t);
		}
	}
	
	public static void bfs(int index) {
		Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
		queue.offer(list.get(index));
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			HashMap<Integer, Integer> tmp = queue.poll();
			
			for(int t : tmp.keySet()) {
				if(!visited[t]) {
					queue.offer(list.get(t));
					visited[t] = true;
				}
			}
		}
	}
}
