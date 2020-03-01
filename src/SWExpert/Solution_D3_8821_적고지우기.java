package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_8821_적고지우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			char[] ch = br.readLine().toCharArray();
			
			int[] numbers = new int[10];
			int len = ch.length;
			
			for(int i=0; i<len; i++){
				int num = ch[i] - '0';
				numbers[num] = (numbers[num] + 1) % 2; 
			}
			
			int cnt = 0;
			
			for(int i=0; i<10; i++){
				if(numbers[i] == 1) cnt++;
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
