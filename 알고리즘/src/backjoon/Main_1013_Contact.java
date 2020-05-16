package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_1013_Contact {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		String pattern = "(100+1+|01)+";
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<testCase; i++) {
			sb.append(Pattern.matches(pattern, br.readLine()) ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb.toString());
	}
}
