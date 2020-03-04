package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_8275_햄스터 {
	public static int n, x, m;
	public static int hamster[], ans[];
	public static Info info[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			hamster = new int[n];
			ans = new int[n];
			Arrays.fill(ans, -1);
			info = new Info[m];
			
			for(int i=0; i<m; i++){
				st = new StringTokenizer(br.readLine(), " ");
				int l, r, s;
				l = Integer.parseInt(st.nextToken()) - 1;
				r = Integer.parseInt(st.nextToken()) - 1;
				s = Integer.parseInt(st.nextToken());
				
				info[i] = new Info(l, r, s);
			}
			
			dfs(0);
			
			if(ans[0] == -1) sb.append("#" + t + " " + "-1\n");
			else{
				sb.append("#" + t + " ");
				for(int i=0; i<n; i++) sb.append(ans[i] + " ");
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth){
		if(depth == n){
			if(check()){
				if(ans[0] != -1){
					int total = 0, totalAns = 0;
					
					for(int i=0; i<n; i++) {
						total += hamster[i];
						totalAns += ans[i];
					}
					
					// 햄스터 수가 가장 많으면서 사전순으로(x부터 시작했기 때문에 뒤에 들어온 것일수록 사전순이 빠름)
					if(totalAns <= total){
						for(int i=0; i<n; i++){
							ans[i] = hamster[i];
						}
					}
				}
				else{
					for(int i=0; i<n; i++){
						ans[i] = hamster[i];
					}
				}
			}
			
			return;
		}
		
		for(int i=x; i>=0; i--){
			hamster[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static boolean check(){
		for(int i=0; i<m; i++){
			int sum = 0;
			
			for(int j=info[i].start; j<=info[i].end; j++){
				sum += hamster[j];
			}
			
			if(sum != info[i].val) return false;
		}
		
		return true;
	}
	
	public static class Info{
		int start;
		int end;
		int val;
		
		public Info(int start, int end, int val) {
			this.start = start;
			this.end = end;
			this.val = val;
		}
	}
}
