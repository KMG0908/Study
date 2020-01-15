package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N과M7 {
	public static int n, m, arr[];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, "");
		System.out.println(sb);
	}
	
	public static void dfs(int depth, String ans) {
		if(depth == m) {
			sb.append(ans + "\n");
		}
		else {
			for(int i=0; i<n; i++) {
				dfs(depth + 1, ans + arr[i] + " ");
			}
		}
	}
}
