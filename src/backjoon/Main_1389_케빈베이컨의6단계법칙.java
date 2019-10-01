package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	public static boolean visited[];
	public static ArrayList<HashMap<Integer, Integer>> list;
	public static int cnt = 0;
	public static int[] kevin;
	public static int[] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		sum = new int[n+1];
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
		
		for(int i=1; i<n+1; i++) {
			kevin = new int[n+1];
			for(int j=1; j<n+1; j++) {
				if(i != j) {
					cnt = 0;
					visited = new boolean[n+1];
					//dfs(i, i, j, 1);
					bfs(i, i, j);
				}
			}
			
			for(int k=1; k<n+1; k++) {
				sum[i] += kevin[k];
			}
		}
		
		int min = sum[1];
		int min_index = 1;
		
		for(int i=2; i<n+1; i++) {
			if(sum[i] < min) {
				min = sum[i];
				min_index = i;
			}
		}
		
		System.out.println(min_index);
	}
	
	public static void dfs(int index, int start, int end, int count) {
		visited[index] = true;
		
		HashMap<Integer, Integer> tmp = list.get(index);
		
		for(int t : tmp.keySet()) {
			if(t == end) {
				if(kevin[end] == 0) kevin[end] = count;
				else kevin[end] = Math.min(kevin[end], count);
				
				return;
			}
			else if(!visited[t]) {
				dfs(t, start, end, count + 1);
				visited[t] = false;		// 더 짧은 경로가 있는지 확인하기 위하여
			}
		}
	}
	
	public static void bfs(int index, int start, int end) {
		Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
		Queue<Integer> cnt = new LinkedList<>();
		queue.offer(list.get(index));
		cnt.offer(1);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			HashMap<Integer, Integer> tmp = queue.poll();
			int count = cnt.poll();
			
			for(int t : tmp.keySet()) {
				if(t == end) {
					if(kevin[end] == 0) kevin[end] = count;
					else kevin[end] = Math.min(kevin[end], count);
					
					return;
				}
				else if(!visited[t]) {
					queue.offer(list.get(t));
					cnt.offer(count + 1);
					visited[t] = false;
				}
			}
		}
	}
}
