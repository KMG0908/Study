package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int res = factorial(n);
		System.out.println(res == 0 ? 1 : res);
	}
	
	public static int factorial(int n) {
		if (n <= 1) return n;
		else return factorial(n-1) * n;
	}
}
