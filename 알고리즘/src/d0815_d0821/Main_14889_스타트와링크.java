package d0815_d0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	public static int n, ability[][], startT[], linkT[], abi[], total, difference = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		startT = new int[n/2];
		linkT = new int[n/2];
		abi = new int[2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(difference);
	}
	 
	public static void dfs(int depth, int start) {		// 스타트팀, 링크팀 분별
		if(depth == n/2) {
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				list.add(i);
			}
			
			for(int i=0; i<n/2; i++) {
				list.remove(list.indexOf(startT[i]));
			}
			
			for(int i=0; i<n/2; i++) {
				linkT[i] = list.get(i);
			}
			
			
			diff(startT, linkT);
		}
		else {
			for(int i=start; i<n; i++) {
				startT[depth] = i;
				dfs(depth + 1, i + 1);
			}
		}
	}
	
	public static void diff(int[] team1, int[] team2) {	// 스타트팀과 링크팀 능력치 차이 최솟값
		total = 0;
		sum(team1, 0, 0);
		int startD = total;
		
		total = 0;
		sum(team2, 0, 0);
		int linkD = total;
		
		if(difference == -1) difference = Math.abs(startD - linkD);
		else difference = Math.min(difference, Math.abs(startD - linkD));
	}
	
	public static void sum(int[] arr, int depth, int start) {	// 팀에서 나올 수 있는 능력치 모두 더하기
		if(depth == 2) {
			total += ability[abi[0]][abi[1]] + ability[abi[1]][abi[0]];
		}
		else {
			for(int i=start; i<arr.length; i++) {
				abi[depth] = arr[i];
				sum(arr, depth + 1, i + 1);
			}
		}
	}
}
