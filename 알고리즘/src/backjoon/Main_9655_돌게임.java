package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9655_돌게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 홀수 개의 돌만 가져갈 수 있으므로 총 개수가 홀수라면 상근이가 이기게 되고 짝수라면 창영이가 이기게 됨
		System.out.println(n % 2 == 1 ? "SK" : "CY");
	}
}
