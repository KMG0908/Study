package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {
	public static int n, m, arr[], number[];
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		number = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0, "");
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start, String ans) {
		if(depth == m) {
			sb.append(ans + "\n");
		}
		else {
			for(int i=start; i<n; i++) {
				dfs(depth + 1, i, ans + arr[i] + " ");
			}
		}
	}
}
