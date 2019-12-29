package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2163_초콜릿자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		/*
		 * N*M 초콜릿을 1*M 초콜릿 N개로 만들기 위해서는 N-1번 잘라야 함
		 * 1*M 초콜릿을 1*1 초콜릿 M개로 만들기 위해서는 M-1번 잘라야 함
		 * => N*M 초콜릿을 1*1 초콜릿 N*M개로 만들기 위해서는 (N-1) + N*(M-1) = N - 1 + N * M - N = N * M - 1
		 */
		
		System.out.println(n * m - 1);
	}
}
