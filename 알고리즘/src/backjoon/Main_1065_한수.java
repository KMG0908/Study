package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n < 100) System.out.println(n);
		else{
			int cnt = 99;
			ing:
			for(int i=100; i<=n; i++){
				int digit = (int)(Math.log10(i) + 1);
				int numbers[] = new int[digit];
				int num = i, idx = digit - 1;
				
				while(num != 0){
					numbers[idx--] = num % 10;
					num /= 10;
				}
				
				int dif = numbers[0] - numbers[1];
				
				for(int j=1; j<digit-1; j++){
					if(dif != numbers[j] - numbers[j+1]) continue ing;
				}
				
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
