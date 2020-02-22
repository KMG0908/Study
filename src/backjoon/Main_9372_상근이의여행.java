package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행 {
	public static int parents[];
	
	public static void make(){
		Arrays.fill(parents, -1);
	}
	
	public static int find(int a){
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=0; t<testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n + 1];
			make();
			
			int airplane = 0;
			for(int i=0; i<m; i++){
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(union(a, b)) airplane++;
			}
			
			sb.append(airplane + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
