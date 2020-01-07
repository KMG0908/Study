package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장 {
	public static int n, m, s, e, dir[] = {-1, 1};
	public static boolean visited[];
	public static ArrayList<Integer> list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		visited[s] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int info = queue.poll();
				
				if(info == e) return cnt;
				
				int nr;
				for(int j=0; j<2; j++) {
					nr = info + dir[j];
					if(nr > 0 && nr <= n && !visited[nr]) {
						queue.offer(nr);
						visited[nr] = true;
					}
				}
				
				if(list[info].size() != 0) {
					for(int tmp : list[info]) {
						if(!visited[tmp]) {
							queue.offer(tmp);
							visited[tmp] = true;
						}
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
}
