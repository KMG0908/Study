package d0822_d0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2529_부등호 {
	public static int n, number[];
	public static char[] inequality;
	public static boolean[] visited;
	public static String max = "-1", min = "-1";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		number = new int[n+1];
		visited = new boolean[10];
		inequality = new char[n];
		
		String str = br.readLine();
		for(int i=0; i<n; i++) {
			inequality[i] = str.charAt(2 * i);
		}
		
		for(int i=0; i<10; i++) {
			number[0] = i;
			visited[i] = true;
			dfs(0);
			visited[i] = false;
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int depth) {
		if(depth == n) {
			String str = "";
			for(int i=0; i<n+1; i++) {
				str += number[i];
			}
			
			if(max.equals("-1")) {
				max = str;
			}
			else {
				if(str.compareTo(max) > 0) max = str;
			}
			
			if(min.equals("-1")) {
				min = str;
			}
			else {
				if(str.compareTo(min) < 0) min =str;
			}
		}
		else {
			for(int i=0; i<10; i++) {
				if(!visited[i]) {
					if(inequality[depth] == '>') {
						if(number[depth] > i) {
							number[depth+1] = i;
							visited[i] = true;
							dfs(depth+1);
							visited[i] = false;
						}
					}
					else {
						if(number[depth] < i) {
							number[depth+1] = i;
							visited[i] = true;
							dfs(depth+1);
							visited[i] = false;
						}
					}
				}
			}
		}
	}
}
