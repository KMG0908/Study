package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			char[] backArr = new char[len];
			Stack<Character> stack = new Stack<>();
			int idx = 0;
			
			for(int i=0; i<len; i++) {
				if(arr[i] >= '0' && arr[i] <= '9') backArr[idx++] = arr[i];
				else {
					if(stack.size() != 0) {
						if(stack.peek() > arr[i]) {	// 43이 +, 42가 *이므로 *이 더 작음
							stack.push(arr[i]);
						}
						else {
							do {
								backArr[idx++] = stack.pop();
								if(stack.size() == 0) break;
							} while(stack.peek() < arr[i]);
							stack.push(arr[i]);
						}
					}
					else stack.push(arr[i]);
				}
			}
			
			while(!stack.isEmpty()) backArr[idx++] = stack.pop();
			
			Stack<Integer> result = new Stack<>();
		    
			for(int i=0; i<len; i++) {
				if(backArr[i] > '0' && arr[i] <= '9') result.push(backArr[i] - '0');
				else {
					if(backArr[i] == '+') {
						result.push(result.pop() + result.pop());
					}
					else {
						result.push(result.pop() * result.pop());
					}
				}
			}
			System.out.println("#" + t + " " + result.pop());
		}
		
	}
}
