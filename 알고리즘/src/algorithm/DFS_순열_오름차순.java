package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_순열_오름차순 {
	public static int n, r, numbers[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		numbers = new int[r];
		
		dfs(0, 0);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == r) {
			for(int i=0; i<r; i++) System.out.print(numbers[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<n; i++) {
			numbers[depth] = i + 1;
			dfs(i + 1, depth + 1);
		}
	}
}
