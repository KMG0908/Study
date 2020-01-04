package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 커밋 메세지 수정
public class Main_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int k=0; k<i; k++) {
				if(arr[i] > arr[k]) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
