package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch = br.readLine().toCharArray();
		
		Arrays.sort(ch);
		
		StringBuffer sb = new StringBuffer();
		for(int i=ch.length-1; i>=0; i--) {
			sb.append(ch[i]);
		}
		
		System.out.println(sb.toString());
	}
}
