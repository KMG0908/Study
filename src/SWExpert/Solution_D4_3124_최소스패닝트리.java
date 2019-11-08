package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {
	private static int parents[];

	static void make() {
		Arrays.fill(parents, -1);
	}
	
	static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());

		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			parents = new int[v + 1];
			make();
			
			int[][] value = new int[e][3];
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				
				value[i][0] = val;
				value[i][1] = a;
				value[i][2] = b;
			}
			
			// 가중치 기준으로 오름차순 정렬
			Arrays.sort(value, new Comparator<int[]>() {
				public int compare(int[] arg0, int[] arg1) {
					return arg0[0] - arg1[0];
				}
			});
			
			long sum = 0;
			int cnt = 0;
			
			for(int i=0; i<e; i++) {
				// 선택하려는 간선의 두 정점이 같은 집합에 포함되어 있지 않다면(union 결과가 true일 때)
				if(union(value[i][1], value[i][2])) {
					sum += value[i][0];
					cnt++;
				}
				
				// V - 1 개의 간선을 사용했을 경우 종료
				if(cnt == v - 1) break;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
