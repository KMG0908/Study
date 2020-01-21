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

public class Main_1325_효율적인해킹 {
	public static int n, m, max, hacking[];
	public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		hacking = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			map.put(i, new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map.get(b).add(a);
		}
		
		for(int i=1; i<=n; i++) {
			bfs(i);
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=1; i<=n; i++) {
			if(hacking[i] == max) sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int start) {
		boolean visited[] = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int info = queue.poll();
			
			ArrayList<Integer> list = map.get(info);
			for(int tmp : list) {
				if(!visited[tmp]) {
					queue.offer(tmp);
					visited[tmp] = true;
					hacking[start]++;
				}
			}
		}
		
		max = Math.max(max, hacking[start]);
	}
}
