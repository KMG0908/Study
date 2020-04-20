package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		next:
		for(int t=1; t<=testCase; t++) {
			char[] ch = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<ch.length; i++) {
				switch(ch[i]) {
				case '(':
					stack.push(ch[i]);
					break;
				case ')':
					if(!stack.isEmpty()) stack.pop();
					else {
						sb.append("NO\n");
						continue next;
					}
					break;
				}
			}
			
			if(stack.isEmpty()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
	}
}
