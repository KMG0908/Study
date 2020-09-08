package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_순열 {
	public static int n, r, numbers[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		numbers = new int[r];
		visited = new boolean[n];
		
		dfs(0);
	}
	
	public static void dfs(int depth) {
		if(depth == r) {
			for(int i=0; i<r; i++) System.out.print(numbers[i] + " ");
			System.out.println();
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			numbers[depth] = i + 1;
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}
