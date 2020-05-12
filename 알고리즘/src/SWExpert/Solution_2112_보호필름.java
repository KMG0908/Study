package SWExpert;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution_2112_보호필름 {
	public static int d, w, k, film[][], numbers[], medicine[], put, min = 0;
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			film = new int[d][w];
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = 0;
			put = 1;
			
			// 약품을 투입해야 하는 경우
			if(!check(film)) {
				while(true) {
					visited = new boolean[d];
					numbers = new int[put];
					
					dfs(0, 0);
					put++;
					
					if(put == d) break;
				}
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	// 어느 약품(A, B)을 투입할 것인지
	public static void dfs(int depth) {
		if(min != 0) return;
		
		if(depth == put) {
			int[][] copy = new int[d][w];
			int idx = 0;
			
			for(int i=0; i<d; i++) {
				if(i == numbers[idx]) {
					Arrays.fill(copy[i], medicine[idx]);
					if(idx + 1 < put) idx++;
				}
				else copy[i] = Arrays.copyOf(film[i], w);
			}
			
			if(check(copy)) min = put;
		}
		else {
			for(int i=0; i<2; i++) {
				medicine[depth] = i;
				dfs(depth + 1);
			}
		}
	}
	
	// 어느 위치에 약품을 투입할 것인지
	public static void dfs(int start, int depth) {
		if(min != 0) return;
		
		if(depth == put) {
			medicine = new int[put];
			dfs(0);
		}
		else {
			for(int i=start; i<d; i++) {
				if(!visited[i]) {
					visited[i] = true;
					numbers[depth] = i;
					dfs(i, depth + 1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static boolean check(int[][] arr) {
		boolean flag = false;
		
		for(int j=0; j<w; j++) {
			flag = false;
			
			ing:
			for(int i=0; i<=d-k; i++) {
				int val = arr[i][j];
				for(int l=i+1; l<i+k; l++) {
					if(val != arr[l][j]) continue ing;
				}
				flag = true;
				break;
			}
			
			if(!flag) break;
		}
		
		return flag;
	}
}
