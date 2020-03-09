package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D3_8931_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0; i<n; i++){
				int num = Integer.parseInt(br.readLine());
				
				if(num == 0) stack.pop();
				else stack.push(num);
			}
			
			int sum = 0;
			while(!stack.isEmpty()){
				sum += stack.pop();
			}
			
			sb.append("#" + t + " " + sum + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
