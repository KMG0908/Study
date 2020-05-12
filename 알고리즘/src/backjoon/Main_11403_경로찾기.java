package backjoon;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_11403_경로찾기 {
	public static ArrayList<HashMap<Integer, Integer>> list;
	public static int map[][];
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(new HashMap<>());
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				if(st.nextToken().equals("1")) {
					list.get(i).put(j, i);
					map[i][j] = 1;
				}
			}
		}

		//System.out.println(list);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0) {
					visited = new boolean[n];
					//dfs(i, i, j);
					bfs(i, i, j);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int index, int start, int end) {
		visited[index] = true;
		HashMap<Integer, Integer> tmp = list.get(index);
		for(int t : tmp.keySet()) {
			if(t == end) {
				map[start][end] = 1;
				return;
			}
			else {
				if(!visited[t]) dfs(t, start, end);
			}
		}
	}
	
	public static void bfs(int index, int start, int end) {
		Queue<HashMap<Integer, Integer>> queue = new LinkedList<>();
		queue.offer(list.get(index));
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			HashMap<Integer, Integer> tmp = queue.poll();
			
			for(int t : tmp.keySet()) {
				if(t == end) {
					map[start][end] = 1;
					return;
				}
				else {
					if(!visited[t]) {
						queue.offer(list.get(t));
						visited[t] = true;
					}
				}
			}
		}
	}
}
