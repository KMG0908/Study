package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1225_이상한곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int aLen = a.length();
		int bLen = b.length();
		
		long sum = 0;
		for(int i=0; i<aLen; i++) {
			for(int j=0; j<bLen; j++) {
				sum += (long)(a.charAt(i) - '0') * (b.charAt(j) - '0');
			}
		}
		
		System.out.println(sum);
	}
}
