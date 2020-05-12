package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344_평균은넘겠지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=c; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			int[] score = new int[n];
			double sum = 0;
			
			for(int i=0; i<n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			
			double avg = sum / n;
			int count = 0;
			
			for(int i=0; i<n; i++) {
				if(score[i] > avg) count++;
			}
			
			System.out.println(String.format("%.3f", (double) count / n * 100) + "%");
		}
	}
}
