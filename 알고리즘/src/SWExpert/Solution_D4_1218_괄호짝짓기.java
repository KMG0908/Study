package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int T=1; T<=10; T++) {
			int n = Integer.parseInt(br.readLine());
			boolean flag = false;
			
			char[] arr = br.readLine().toCharArray();
			Stack<Character> parentheses = new Stack<>();
			
			out:
			for(int i=0; i<arr.length; i++) {
				switch(arr[i]) {
				case '(':
				case '[':
				case '{':
				case '<':
					parentheses.push(arr[i]);
					break;
				case ')':
					if(parentheses.peek() == '(') parentheses.pop();
					else break out;
					break;
				case ']':
					if(parentheses.peek() == '[') parentheses.pop();
					else break out;
					break;
				case '}':
					if(parentheses.peek() == '{') parentheses.pop();
					else break out;
					break;
				case '>':
					if(parentheses.peek() == '<') parentheses.pop();
					else break out;
					break;
				}
			}
			
			if(parentheses.isEmpty()) flag = true;
			
			if(flag) System.out.println("#" + T + " " + 1);
			else System.out.println("#" + T + " " + 0);
		}
	}
}
