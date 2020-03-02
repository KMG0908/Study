package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D5_4534_트리흑백색칠 {
	public static final int MOD = 1000000007;
	public static int n;
	public static List<Integer>[] adj;
	public static long[][] memo;	// 색상, 정점 번호
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			// 자기 자신일 경우: 자신이 흑일 때의 경우의 수와 자신이 백일 때의 경우의 수를 더합
			// 자기 자신의 
			n = Integer.parseInt(br.readLine());
			adj = new LinkedList[n + 1];
			memo = new long[2][n + 1];
			
			for(int i=1; i<=n; i++){
				adj[i] = new LinkedList<>();
			}
			
			for(int i=0; i<n-1; i++){
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a].add(b);
				adj[b].add(a);
			}
			
			long ans = (dfs(1, 0, 0) + dfs(1, 1, 0)) % MOD;
			sb.append("#" + t + " " + ans + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long dfs(int v, int color, int parent){
		// memo[color][v] 값이 존재한다면 다시 계산하지 않고 알고 있던 값 리턴
		if(memo[color][v] != 0) return memo[color][v];
		
		long ret = 1;
		
		// color가 흑(0)인 경우
		// 자식 노드들을 백(1)으로 칠한 경우의 경우의 수들의 곱
		if(color == 0){
			for(int child : adj[v]){
				if(child != parent){
					ret *= dfs(child, 1, v);
					ret %= MOD;
				}
			}
		}
		
		// color가 백(1)일 경우
		// 자식 노드들을 흑(0)으로 칠한 경우의 경우의 수들의 곱 + 자식 노드들을 백(1)으로 칠한 경우의 경우의 수들의 곱
		if(color == 1){
			for(int child : adj[v]){
				if(child != parent){
					ret *= (dfs(child, 0, v) + dfs(child, 1, v));
					ret %= MOD;
				}
			}
		}
		
		// memo[color][v]에 기록
		memo[color][v] = ret;
		
		return ret;
	}
}
