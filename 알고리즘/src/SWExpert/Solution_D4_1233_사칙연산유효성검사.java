package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int res = 1;
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				ArrayList<String> list = new ArrayList<>();
				while(st.hasMoreTokens()) list.add(st.nextToken());
				
				if(list.size() == 4) {	// 자식이 양쪽으로 있을 경우
					String str = list.get(1);
					if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) continue;
					else {
						res = 0;
					}
				}
				else if(list.size() == 2) {	// 자식이 없을 경우
					String str = list.get(1);
					if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
						res = 0;
					}
					else continue;
				}
				else {			// 자식이 한쪽만 있을 경우
					res = 0;
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
