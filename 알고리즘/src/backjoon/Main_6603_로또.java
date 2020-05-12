package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	public static int lotto[], combi[], n;
	public static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			lotto = new int[n];
			combi = new int[6];
			list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println();
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(combi[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			combi[depth] = lotto[i];
			dfs(i + 1, depth + 1);
		}
	}
}
