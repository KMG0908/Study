package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2660_회장뽑기 {
	public static boolean[] visited;
	public static int[] score;
	public static ArrayList<HashMap<Integer, Integer>> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		score = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			list.add(new HashMap<>());
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1) break;
			
			list.get(a).put(b, a);
			list.get(b).put(a, b);
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		
		int min = n;
		for(int i=1; i<=n; i++) {
			min = Math.min(min, score[i]);
		}
		
		int people = 0;
		for(int i=1; i<=n; i++) {
			if(score[i] == min) people++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(min + " " + people + "\n");
		
		for(int i=1; i<=n; i++) {
			if(score[i] == min) sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int index) {
		Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
		Queue<Integer> cnt = new LinkedList<>();
		
		queue.offer(list.get(index));
		cnt.offer(0);
		visited[index] = true;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			HashMap<Integer, Integer> tmp = queue.poll();
			count = cnt.poll();
			
			for(int t : tmp.keySet()) {
				if(!visited[t]) {
					queue.offer(list.get(t));
					cnt.offer(count + 1);
					visited[t] = true;
				}
			}
		}
		
		score[index] = count;
	}
}
