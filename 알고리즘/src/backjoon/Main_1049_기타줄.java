package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int set = Integer.MAX_VALUE;
		int single = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			set = Math.min(set, Integer.parseInt(st.nextToken()));
			single = Math.min(single, Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		// 6개를 세트로 하나 사는 것보다 낱개로 6개 사는 게 쌀 경우 낱개로 계산
		if(set > single * 6) res += single * (n / 6) * 6;
		// 6개를 세트로 하나 사는 게 낱개로 6개 샀을 때보다 쌀 경우 세트로 계산
		else res += set * (n / 6);
		// 6n개 산 후의 나머지
		n %= 6;
		
		// 세트로 사는 것보다 낱개로 n개를 사는게 더 쌀 경우 낱개로 계산
		if(set > single * n) res += single * n;
		// 세트로 사는 게 낱개로 사는 것보다 쌀 경우 세트로 계산
		else res += set;
		
		System.out.println(res);
	}
}
