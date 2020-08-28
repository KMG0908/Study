package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1373_2진수8진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		
		int length = num.length() % 3;
		if(length != 0) length = 3 - length;
		
		for(int i=0; i<length; i++) {
			num = "0" + num;
		}
		
		length = num.length() / 3;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			int mul = i * 3;
			
			int four = (num.charAt(mul + 0) - '0') * 4;
			int two = (num.charAt(mul + 1) - '0') * 2;
			int one = (num.charAt(mul + 2) - '0') * 1;
			
			int add = four + two + one;
			
			/*
			 * String + 연산으로 처리할 경우 메모리 초과로 실패
			 * String 객체는 immutable하기 때문에 += 을 할 때마다 기존의 내용을 모두 복사해서 새로운 객체를 만들고, 그 뒤에 문자열을 이어붙여야 함
			 * 기존의 객체는 쓸모가 없어지므로 버려져야 하는데 이게 메모리에서 실제로 해제되기까지는 시간이 걸림
			 */
			sb.append(add); 
		}
		
		System.out.println(sb.toString());
	}
}
