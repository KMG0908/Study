package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이의은행업무 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			String binary = br.readLine();
			String triple = br.readLine();
			
			for(int i=0; i<binary.length(); i++) {
				if(binary.charAt(i) == '0') {
					binary = binary.substring(0, i) + 1 + binary.substring(i+1);
					
					long num = Long.parseLong(binary, 2);	// 2진수 -> 10진수
					String binary_to_triple = Long.toString(num, 3);	// 10진수 -> 3진수
					
					// 2진수를 3진수로 변환한 수가 값으로 들어온 3진수의 자리수보다 크다면 패스
					if(binary_to_triple.length() > triple.length()) {
						binary = binary.substring(0, i) + 0 + binary.substring(i+1);
						continue;
					}
					
					// 부족한 자리수만큼 앞에 0 붙이기
					if(binary_to_triple.length() < triple.length())
						binary_to_triple = String.format("%0" + triple.length() + "d", Long.parseLong(binary_to_triple));
					
					boolean flag = false;
					for(int j=0; j<triple.length(); j++) {
						if(binary_to_triple.charAt(j) != triple.charAt(j)) {
							if(flag) {
								flag = false;
								break;
							}
							else flag = true;
						}
					}
					
					if(flag) {
						sb.append("#" + t + " " + num + "\n");
						break;
					}
					
					binary = binary.substring(0, i) + 0 + binary.substring(i+1);
				}
				else {
					binary = binary.substring(0, i) + 0 + binary.substring(i+1);
					
					long num = Long.parseLong(binary, 2);	// 2진수 -> 10진수
					String binary_to_triple = Long.toString(num, 3);	// 10진수 -> 3진수
					
					if(binary_to_triple.length() > triple.length()) {
						binary = binary.substring(0, i) + 1 + binary.substring(i+1);
						continue;
					}
					
					if(binary_to_triple.length() < triple.length())
						binary_to_triple = String.format("%0" + triple.length() + "d", Long.parseLong(binary_to_triple));
					
					boolean flag = false;
					for(int j=0; j<triple.length(); j++) {
						if(binary_to_triple.charAt(j) != triple.charAt(j)) {
							if(flag) {
								flag = false;
								break;
							}
							else flag = true;
						}
					}
					
					if(flag) {
						sb.append("#" + t + " " + num + "\n");
						break;
					}
					
					binary = binary.substring(0, i) + 1 + binary.substring(i+1);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
