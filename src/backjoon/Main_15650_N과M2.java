package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	public static int n, m, numbers[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		
		dfs(0, 0);
	}
	
	public static void dfs(int start, int depth){
		if(depth == m){
			for(int i=0; i<m; i++){
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}
		else{
			for(int i=start; i<n; i++){
				numbers[depth] = i + 1;
				dfs(i + 1, depth + 1);
			}
		}
	}
}
