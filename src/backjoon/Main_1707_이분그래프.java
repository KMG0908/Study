package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
	public static int[] vertex;
	public static boolean[] visited;
	public static ArrayList<HashMap<Integer, Integer>> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			vertex = new int[v + 1];
			Arrays.fill(vertex, -1);
			visited = new boolean[v + 1];
			
			list = new ArrayList<>();
			
			for(int i=0; i<v+1; i++) {
				list.add(new HashMap<>());
			}
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).put(b, a);
				list.get(b).put(a, b);
			}
			
			
			boolean flag = true;
			String str = "YES";
			
			for(int i=1; i<v+1; i++) {
				if(vertex[i] == -1) flag = bfs(i);
				if(!flag) {
					str = "NO";
					break;
				}
			}
			
			flag = bfs(1);
			if(!flag) str = "NO";
			
			System.out.println(str);
		}
	}
	
	public static boolean bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		visited[index] = true;
		vertex[index] = 0;
		
		boolean flag = true;
		
		exit:
		while(!queue.isEmpty()) {
			int info = queue.poll();
			int color = vertex[info];
			HashMap<Integer, Integer> tmp = list.get(info);
			
			for(int t : tmp.keySet()) {
				if(vertex[t] == -1) {
					queue.offer(t);
					vertex[t] = (color + 1) % 2;
				}
				else {
					if(vertex[t] != (color + 1) % 2) {
						flag = false;
						break exit;
					}
				}
			}
		}
		
		return flag;
	}
}
