package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1108_페이지전환 {
	public static int n, size = 0, total[][];
	public static boolean matrix[][], visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		matrix = new boolean[501][501];

		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			size = Math.max(size, Math.max(a, b));
			
			matrix[a][b] = true;
		}
		
		total = new int[size + 1][size + 1];
		
		for(int i=1; i<size+1; i++) {
			visited = new boolean[size + 1];
			bfs(i);
		}
		
		int sum = 0;
		for(int i=1; i<size+1; i++) {
			for(int j=1; j<size+1; j++) {
				if(total[i][j] != 0) {
					sum += total[i][j];
				}
			}
		}
		
		System.out.println(String.format("%.3f", (double) sum / (size * (size - 1))));
	}
	
	public static void bfs(int idx) {
		Queue<Count> queue = new LinkedList<>();
		queue.offer(new Count(idx, 0));
		visited[idx] = true;
		
		while(!queue.isEmpty()) {
			Count count = queue.poll();
			
			for(int j=1; j<size+1; j++) {
				if(!visited[j] && matrix[count.idx][j]) {
					total[idx][j] = count.cnt + 1;
					queue.offer(new Count(j, count.cnt + 1));
					visited[j] = true;
				}
			}
		}
	}
	
	public static class Count {
		int idx;
		int cnt;
		
		public Count(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
