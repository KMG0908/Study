package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			char before = str.charAt(0);
			boolean[] visited = new boolean[26];
			visited[before - 'a'] = true;
			boolean group = true;
			
			for(int j=1; j<str.length(); j++) {
				if(before == str.charAt(j)) continue;
				
				before = str.charAt(j);
				
				if(visited[before - 'a']) {
					group = false;
					break;
				}
				
				visited[before - 'a'] = true;
			}
			
			if(group) cnt++;
		}
		
		System.out.println(cnt);
	}
}
