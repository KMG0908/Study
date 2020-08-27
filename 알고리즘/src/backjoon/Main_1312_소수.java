package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1312_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int res = 0;
		a %= b;
		while(n > 0) {
			if(a < b) a *= 10;
			res = a / b;
			a %= b;
			n--;
		}
		
		System.out.println(res);
	}
}
