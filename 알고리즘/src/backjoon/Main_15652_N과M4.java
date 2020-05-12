package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {
	public static int n, m, numbers[];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		
		dfs(0, 1);
		
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
			for(int i=start; i<=n; i++) {
				numbers[depth] = i;
				dfs(depth + 1, i);
			}
		}
	}
}
