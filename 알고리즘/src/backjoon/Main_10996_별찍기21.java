package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10996_별찍기21 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n*2; i++) {
			for(int j=0; j<n; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0) sb.append("*");
					else sb.append(" ");
				}
				else {
					if(j % 2 == 0) sb.append(" ");
					else sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
