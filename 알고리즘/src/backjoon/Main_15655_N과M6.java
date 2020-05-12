package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N과M6 {
	public static int n, m, arr[], numbers[];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		numbers = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int start) {
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
		}
		else {
			for(int i=start; i<n; i++) {
				numbers[depth] = arr[i];
				dfs(depth + 1, i + 1);
			}
		}
	}
}
