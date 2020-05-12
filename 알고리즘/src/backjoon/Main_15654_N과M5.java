package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	public static int n, m, arr[], numbers[];
	public static boolean visited[];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		numbers = new int[m];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth) {
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				if(!visited[i]){
					visited[i] = true;
					numbers[depth] = arr[i];
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
