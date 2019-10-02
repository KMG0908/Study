package d1001_d1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 문제 푼 시간: 40분
 * SWExpert에 있는 문제랑 비슷해서 arr[i] >= arr[k]일 경우로 생각해서 헤맴...
 */
public class Main_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] before = new int[n];
		
		Arrays.fill(before, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int index = 0;
		dp[0] = 1;
		
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int k=0; k<i; k++) {
				if(arr[i] > arr[k]) {
					if(dp[k] + 1 > dp[i]) {
						dp[i] = dp[k] + 1;
						before[i] = k;
					}
				}
			}
			
			if(dp[i] > max) {
				max = dp[i];
				index = i;
			}
		}
		
		System.out.println(max);
		
		ArrayList<Integer> list = new ArrayList<>();
		while(index != -1) {
			list.add(arr[index]);
			index = before[index];
		}
		
		Collections.sort(list);
		int size = list.size();
		for(int i=0; i<size; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
