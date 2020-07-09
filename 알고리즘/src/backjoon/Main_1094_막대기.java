package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1094_막대기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		int stick = 64;
		int cnt = 0;
		
		// X가 0이라면 Xcm의 막대기를 만든 것이다
		while(x > 0) {
			// 막대기가 X보다 크다면 반으로 자른다
			if(stick > x) stick /= 2;
			// 막대기가 X보다 작거나 같을 경우, 그 막대기는 Xcm를 만드는 데 사용되는 것이다
			else {
				x -= stick;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
