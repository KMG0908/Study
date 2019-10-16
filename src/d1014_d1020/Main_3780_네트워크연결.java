package d1014_d1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3780_네트워크연결 {
	static int parents[], value[][];
	
	public static void make() {
		Arrays.fill(parents, -1);
	}
	
	public static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			
			parents = new int[n + 1];
			value = new int[n + 1][n + 1];
			make();
			
			while(true) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				String oper = st.nextToken();
				
				if(oper.equals("E")) {
					int a = Integer.parseInt(st.nextToken());
				}
				else if(oper.equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
					if(union(a, b)) {
						
					}
					System.out.println(Arrays.toString(parents));
				}
				else break;
				
			}
		}
	}
}
