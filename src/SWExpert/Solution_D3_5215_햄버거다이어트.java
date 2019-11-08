package SWExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] count = new int[testCase];
		
		for(int i=0; i<testCase; i++) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int[] score = new int[n];
			int[] calorie = new int[n];
			
			int[] arr = new int[n];
			boolean[] visited = new boolean[n];
			
			for(int j=0; j<n; j++) {
				score[j] = sc.nextInt();
				calorie[j] = sc.nextInt();
			}
			
			for(int j=0; j<n; j++) {
				arr[j] = j;
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=1; j<=n ;j++) {
	            combination(calorie, score, list, visited, 0, n, j, l);
	        }
			
			count[i] = Collections.max(list);
		}
		
		for(int i=0; i<count.length; i++) System.out.printf("#%d %d\n", i+1, count[i]);
	}
	
	static void combination(int[] calorie, int[] score, ArrayList<Integer> list, boolean[] visited, int start, int n, int r, int l) {
	    if(r == 0) {
	    	int totalCalorie = 0;
	    	int totalScore = 0;
	    	for(int i=0; i<n; i++) {
	            if(visited[i] == true) {
	            	totalCalorie += calorie[i];
	            	totalScore += score[i];
	            }
	        }
	    	
	    	if(totalCalorie <= l) list.add(totalScore);
	        
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(calorie, score, list, visited, i + 1, n, r - 1, l);
	            visited[i] = false;
	        }
	    }
	}
}
