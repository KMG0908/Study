package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009_분산처리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long res = a;
			
			// 모든 숫자는 4 순환 주기마다 동일한 숫자가 나온다
			b = b % 4 + 4;
			
			for(int j=1; j<b; j++) {
				res = res * a % 10;
			}
			
			if(res == 0) res = 10;
			
			sb.append(res + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
