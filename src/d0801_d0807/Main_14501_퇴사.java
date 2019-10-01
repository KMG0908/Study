package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	static int[] t, p;
	static int n, max;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		t = new int[n];
		p = new int[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			maxBenefit(i, 0);
		}
		
		System.out.println(max);
	}
	
	public static void maxBenefit(int index, int time) {
		if(index == n) {
			int benefit = 0;
			
			for(int i=0; i<n; i++) {
				if(visited[i]) benefit += p[i];
			}
			
			if(benefit > max) max = benefit;
			
			return;
		}
		
		if(time == 0 && t[index] + index <= n) {	// 현재 상담 중인 것이 없고, 퇴사 전에 상담을 완료할 수 있는 경우
			visited[index] = true;
			maxBenefit(index + 1, t[index]-1>0? t[index]-1 : 0);	// 상담이 끝나지 않은 경우에만 -1		
		}
		
		visited[index] = false;
		maxBenefit(index + 1, time-1>0 ? time-1 : 0);			// 다음 날짜로 이동
	}
}
