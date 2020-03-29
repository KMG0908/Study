package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int temperature[] = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++){
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<k; i++){
			sum += temperature[i];
		}
		int max = Math.max(Integer.MIN_VALUE, sum);
		
		for(int i=k; i<n; i++){
			sum = sum - temperature[i - k] + temperature[i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
