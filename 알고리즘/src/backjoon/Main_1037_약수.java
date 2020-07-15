package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1037_약수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<cnt; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		// 제일 작은 약수 * 제일 큰 약수 = n
		// ex) 12 => 1, 2, 3, 4, 6, 12 => 1과 12제외 2, 3, 4, 6 => 2 * 6 = 12
		System.out.println(min * max);
	}
}
