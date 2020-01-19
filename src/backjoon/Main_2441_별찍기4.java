package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2441_별찍기4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				sb.append(" ");
			}
			for(int j=n; j>i; j--){
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
