package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193_분수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int i = 0;
		int sum = 0;
		
		while(i + sum < n) {
			sum += i++;
		}
		
		int child = (i % 2 == 0)? n - sum : i + 1 - (n - sum);
		int parent = i + 1 - child;
		
		System.out.printf("%d/%d", child, parent);
	}
}
