package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2444_별찍기7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n; i++){
			for(int j=n-1; j>i; j--){
				sb.append(" ");
			}
			for(int j=0; j<=i*2; j++){
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				sb.append(" ");
			}
			for(int j=i; j<n*2-i-1; j++){
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
