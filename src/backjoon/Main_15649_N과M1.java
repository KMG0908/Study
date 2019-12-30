package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {
	public static int n, m, numbers[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		visited = new boolean[n];
		
		dfs(0);
	}
	
	public static void dfs(int depth){
		if(depth == m){
			for(int i=0; i<m; i++) System.out.print(numbers[i] + " ");
			System.out.println();
		}
		else{
			for(int i=0; i<n; i++){
				if(!visited[i]){
					visited[i] = true;
					numbers[depth] = i + 1;
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
