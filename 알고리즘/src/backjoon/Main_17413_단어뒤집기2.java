package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		
		boolean flag = false;
		
		for(int j=0; j<len; j++) {
			if(str.charAt(j) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append("<");
				flag = true;
			}
			else if(str.charAt(j) == '>') {
				sb.append(">");
				flag = false;
			}
			else if(flag) sb.append(str.charAt(j));
			else if(str.charAt(j) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			else {
				stack.push(str.charAt(j));
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
