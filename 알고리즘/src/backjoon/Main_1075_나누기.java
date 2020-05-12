package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1075_나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		
		n = n / 100 * 100;
		int mod = n % f;
		
		if(mod == 0) System.out.println("00");
		else System.out.println(String.format("%02d", f - mod));
	}
}
