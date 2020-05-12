package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	public static int[] parents;
	
	public static void make() {
		Arrays.fill(parents, -1);
	}
	
	public static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parents[aRoot] = bRoot;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		parents = new int[n+1];
		make();
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				int city_connect = Integer.parseInt(st.nextToken());
				
				// 1이면 연결된 것이므로 합치기
				if(city_connect == 1) union(i, j);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int travel = Integer.parseInt(st.nextToken());
		// 제일 첫 경로의 부모 찾기
		int f = find(travel);
		
		for(int i=1; i<m; i++) {
			travel = Integer.parseInt(st.nextToken());
			
			// 갈 수 있다면 제일 첫 경로의 부모와 지나가는 경로의 부모가 같을 것임
			if(f != find(travel)) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
	}
}
