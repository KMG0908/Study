package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_8383_숫자선물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String num = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			
			if(a == 0) flag = false;
			
			StringBuffer sb = new StringBuffer();
			
			int len = num.length();
			
			out:
			for(int i=0; i<len; i++) {
				int n = num.charAt(i) - '0';
				
				if(b == n) sb.append(b);
				else if(a == n) sb.append(a);
				else if(b < n) {
					for(int j=i; j<len; j++) {
						sb.append(b);
					}
					break;
				}
				else if(a < n) {
					if(flag) {
						sb.append(a);
						for(int j=i+1; j<len; j++) {
							sb.append(b);
						}
						break;
					}
					// 첫 자리에 0이 올 수밖에 없는 경우
					else break;
				}
				// 아무런 숫자도 올 수 없는 경우
				else {
					int l = sb.length() - 1;
					for(int j=l; j>=0; j--) {
						// 그 앞에 존재하는 큰 수를 작은 수로 바꾼 뒤 나머지는 큰 수로 채우면 됨
						if(Integer.parseInt(sb.substring(j, j+1)) == b) {
							sb.replace(j, j+1, String.valueOf(a));
							sb.setLength(j+1);
							
							for(int k=j+1; k<len; k++) sb.append(b);
							break out;
						}
					}
					// 숫자를 바꾸지 못하는 경우 그냥 밖으로 빠져나가서 전체 길이보다 1자리 작은 수를 모두 큰 숫자로 채움
					break;
				}
				
				flag = true;
			}
			
			// 자리수가 다르다면 전체 길이보다 1자리 작은 수를 모두 큰 숫자로 채울 수 있음
			if(sb.length() != num.length()) {
				sb = new StringBuffer();
				for(int j=1; j<len; j++) {
					sb.append(b);
				}
			}
			
			if(sb.length() == 0) System.out.println("#" + t + " " + "-1");
			else System.out.println("#" + t + " " + sb.toString());
		}
	}
}
