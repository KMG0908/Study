package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10992_별찍기17 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		int middle = n - 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<middle-i; j++) {
				sb.append(" ");
			}
			for(int j=middle-i; j<=middle+i; j++) {
				if(j == middle - i || j == middle + i || i == n - 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
