package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {
	public static boolean visited[][];
	public static char numbers[];
	public static int res;
	public static int chance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			numbers = st.nextToken().toCharArray();
			chance = Integer.parseInt(st.nextToken());
			visited = new boolean[1000000][chance+1];
			res = 0;
			
			dfs(0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	
	public static void dfs(int cnt) {
		if(visited[getInt(numbers)][cnt]) return;
		visited[getInt(numbers)][cnt] = true;
		
		if(cnt == chance) {
			if(res < getInt(numbers)) res = getInt(numbers);
		}
		else {
			for(int i=0; i<numbers.length-1; i++) {
				for(int j=i+1; j<numbers.length; j++) {
					swap(i, j);
					dfs(cnt+1);
					swap(j, i);
				}
			}
		}
	}
	
	public static void swap(int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static int getInt(char[] ch) {
		return Integer.valueOf(String.valueOf(ch));
	}
}
