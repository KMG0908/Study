package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_15663_N과M9 {
	public static int n, m, arr[], number[];
	public static boolean visited[];
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		number = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, "");
		for(String ans : set) {
			System.out.println(ans);
		}
	}
	
	public static void dfs(int depth, String ans) {
		if(depth == m) {
			set.add(ans);
		}
		else {
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(depth + 1, ans + arr[i] + " ");
					visited[i] = false;
				}
			}
		}
	}
}
