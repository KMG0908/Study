package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static boolean[] visited;
	public static ArrayList<HashMap<Integer, Integer>> list;
	public static int cnt = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		
		visited = new boolean[n+1];
		
		list = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			list.add(new HashMap<>());
		}
		
		StringTokenizer st;
		for(int i=0; i<len; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).put(b, a);
			list.get(b).put(a, b);
		}
		
		//System.out.println(list);
		
		HashMap<Integer, Integer> tmp = list.get(1);
		for(int t : tmp.keySet()) {
			if(!visited[t]) {
				//dfs(t);
				bfs(t);
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int index) {
		cnt++;
		visited[index] = true;
		
		HashMap<Integer, Integer> tmp = list.get(index);
		for(int t : tmp.keySet()) {
			if(!visited[t]) dfs(t);
		}
	}
	
	public static void bfs(int index) {
		cnt++;
		Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
		queue.offer(list.get(index));
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			HashMap<Integer, Integer> tmp = queue.poll();
			
			for(int t : tmp.keySet()) {
				if(!visited[t]) {
					cnt++;
					queue.offer(list.get(t));
					visited[t] = true;
				}
			}
		}
	}
}
