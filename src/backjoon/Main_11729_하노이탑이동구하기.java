package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11729_하노이탑이동구하기 {
	static int count = 0;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n, 1, 2, 3);					// n개의 원반을 1번 기둥에서 2번 기둥을 거쳐 3번 기둥으로 옮긴다.
		sb.insert(0, count + "\n");
		System.out.println(sb);
	}
	
	// 1. 기둥 1에서 n-1개의 원반을 기둥 2로 옮긴다.
	// 2. 기둥 1에서 1개(마지막 원반)을 기둥 3으로 옮긴다.
	// 3. 기둥 2에서 n-1개의 원반을 기둥 3으로 옮긴다.
	private static void hanoi(int n, int from, int by, int to) {
		count++;
		
		if (n == 1)
			sb.append(from + " " + to + "\n");
	    else{
	        hanoi(n - 1, from, to, by);    		// n-1개의 원반을 기둥1에서 기둥 3을 거쳐 기둥 2로 옮긴다.               
	        sb.append(from + " " + to + "\n");	// 1개의 원반을 3번 기둥으로 옮긴다.
	        hanoi(n - 1, by, from, to);    		// n-1개의 원반을 기둥 2에서 기둥1을 거쳐 기동3으로 옮긴다.
	    }
	}
}
