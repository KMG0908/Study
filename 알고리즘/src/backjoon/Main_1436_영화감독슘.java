package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독슘 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num = 0;
		
		while(n > 0) {
			num++;
			
			if(Integer.toString(num).contains("666")) n--;
		}
		
		System.out.println(num);
	}
}
