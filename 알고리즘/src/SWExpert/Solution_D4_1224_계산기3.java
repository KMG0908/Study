package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_D4_1224_계산기3 {
	public static int priority(int value, boolean flag) {
		if(flag) {				// true면 stack에 있는 값
			switch(value) {
			case '*':
				return 2;
			case '+':
				return 1;
			case '(':
				return 0;
			}
		}
		else {
			switch(value) {
			case '*':
				return 2;
			case '+':
				return 1;
			case '(':
				return 3;
			case ')':
				return -1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1; t<=10; t++) {
			int len = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			char[] backArr = new char[len];
			Stack<Character> stack = new Stack<>();
			int idx = 0;
			int isp = -1;
			int icp = -1;
			
			for(int i=0; i<len; i++) {
				if(arr[i] >= '0' && arr[i] <= '9') backArr[idx++] = arr[i];
				else {
					if(stack.size() != 0) {
						isp = priority(stack.peek(), true);
						icp = priority(arr[i], false);
						
						if(icp == -1) {
							do {							// ) 이면 (를 만날 때까지 pop
								backArr[idx++] = stack.pop();
								
								if(stack.size() == 0) break;
							} while(stack.peek() != '(');
							stack.pop();					// ( 버림
						}
						else if(icp > isp) {
							stack.push(arr[i]);
						}
						else {
							do {
								backArr[idx++] = stack.pop();
								
								if(stack.size() == 0) break;
								
								isp = priority(stack.peek(), true);
							} while(icp < isp);
							stack.push(arr[i]);
						}
					}
					else stack.push(arr[i]);
				}
			}
			
			while(!stack.isEmpty()) backArr[idx++] = stack.pop();
			
			Stack<Integer> result = new Stack<>();
		    
			for(int i=0; i<len; i++) {
				if(backArr[i] == '\u0000') break;
				
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
