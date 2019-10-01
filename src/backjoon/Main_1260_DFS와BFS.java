package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 참고: https://sundries-in-myidea.tistory.com/4
public class Main_1260_DFS와BFS {
	public static boolean visited[];
	public static ArrayList<TreeMap<Integer, Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n + 1];
		list = new ArrayList<>();
		
		for(int i=0; i<n + 1; i++) {
			list.add(new TreeMap<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).put(b, a);
			list.get(b).put(a, b);
		}
		
		//System.out.println(list);
		
		dfs(start);
		System.out.println();
		visited = new boolean[n+1];
		bfs(start);
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		System.out.print(index + " ");
		
		TreeMap<Integer, Integer> tmp = list.get(index);
		
		for(int j : tmp.keySet()) {
			if(!visited[j]) dfs(j);
		}
	}
	
	public static void bfs(int index) {
		Queue<TreeMap<Integer, Integer>> queue = new LinkedList<>();
		queue.offer(list.get(index));
		visited[index] = true;
		System.out.print(index + " ");
		
		while(!queue.isEmpty()) {
			TreeMap<Integer, Integer> tmp = queue.poll();
			
			for(int j : tmp.keySet()) {
				if(!visited[j]) {
					System.out.print(j + " ");
					queue.offer(list.get(j));
					visited[j] = true;
				}
			}
		}
	}
}
