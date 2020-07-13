package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int jimin = Integer.parseInt(st.nextToken());
		int hansu = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while(jimin != hansu) {
			jimin = jimin / 2 + jimin % 2;
			hansu = hansu / 2 + hansu % 2;
			count++;
		}
		
		System.out.println(count);
	}
}
