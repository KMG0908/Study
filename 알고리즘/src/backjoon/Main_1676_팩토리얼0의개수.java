package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int two = 0, five = 0;
		
		for(int i=2; i<=n; i*=2) {
			two += n / i;
		}
		
		for(int i=5; i<=n; i*=5) {
			five += n / i;
		}
		
		System.out.println(two > five ? five : two);
	}
}
