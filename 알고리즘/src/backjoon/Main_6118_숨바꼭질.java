package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[n + 1][n + 1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		
		int dest = Integer.MAX_VALUE, dist = -1, cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt = size;
			
			for(int i=0; i<size; i++) {
				int info = queue.poll();
				dest = Math.min(dest, info);
				
				for(int j=1; j<n+1; j++) {
					if(map[info][j] && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
			
			dist++;
			
			if(queue.size() != 0) dest = Integer.MAX_VALUE;
		}
		
		System.out.println(dest + " " + dist + " " + cnt);
	}
}
