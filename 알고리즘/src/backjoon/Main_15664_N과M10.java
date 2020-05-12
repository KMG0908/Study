package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_15664_N과M10 {
	public static int n, m, arr[], number[];
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
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
		for(String ans : set) {
			System.out.println(ans);
		}
	}
	
	public static void dfs(int depth, int start, String ans) {
		if(depth == m) {
			set.add(ans);
		}
		else {
			for(int i=start; i<n; i++) {
				dfs(depth + 1, i + 1, ans + arr[i] + " ");
			}
		}
	}
}
