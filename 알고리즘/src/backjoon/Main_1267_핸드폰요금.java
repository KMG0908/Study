package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1267_핸드폰요금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int y = 0;
		int m = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int time = Integer.parseInt(st.nextToken());
			y += ((time / 30) + 1) * 10;
			m += ((time / 60) + 1) * 15;
		}
		
		if(y < m) System.out.println("Y " + y);
		else if(y > m) System.out.println("M " + m);
		else System.out.println("Y M " + y);
	}
}
