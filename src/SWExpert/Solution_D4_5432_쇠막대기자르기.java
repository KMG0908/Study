package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Solution_D4_5432_쇠막대기자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int T=1; T<=testCase; T++) {
			char[] arr = br.readLine().toCharArray();
			Stack<Integer> stack = new Stack<>();
			
			int slice = 0;
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == '(') {
					stack.push(i);
					slice++;
				}
				else if(arr[i] == ')') {
					int top = stack.peek();
					stack.pop();
					if(i - top == 1) {
						slice += stack.size();
						slice--;
					}
				}
			}

			System.out.println("#" + T + " " + slice);
		}
	}
}
