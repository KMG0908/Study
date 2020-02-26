package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int digit = (int)(Math.log10(n) + 1);
		int min = n - 9 * digit > 0 ? n - 9 * digit : 0;
		
		for(int i=min; i<=n; i++){
			int num = i, sum = 0;
			
			while(num != 0){
				sum += num % 10;
				num /= 10;
			}
			
			if(i + sum == n) {
				System.out.println(i);
				System.exit(0);
			}
		}
		
		System.out.println(0);
	}
}
