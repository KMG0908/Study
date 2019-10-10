package d1007_d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	public static int n, k, alphabet[];
	public static boolean visited[];
	public static String word[];
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new boolean[26];
		
		word = new String[n];
		
		visited['a' - 'a'] = visited['n' - 'a'] = visited['t' - 'a'] = visited['i' - 'a'] = visited['c' - 'a'] = true;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			word[i] = str.substring(4, str.length() - 4).replaceAll("(a|n|t|i|c)", "");
		}
		
		if(k - 5 > 0) {
			dfs(k - 5, 0);
		}
		else if(k - 5 == 0) {
			max = check();
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int k, int index) {
		if(k == 0) {
			max = Math.max(max, check());
			return;
		}
		
		for(int i=index; i<26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(k - 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		
		ing:
		for(int i=0; i<n; i++) {
			for(char ch : word[i].toCharArray()) {
				if(!visited[ch - 'a']) continue ing;
			}
			cnt++;
		}
		
		return cnt;
	}
}
