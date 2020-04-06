package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9093_단어뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			StringBuffer sb = new StringBuffer();
			int len = str.length();
			
			for(int j=0; j<len; j++) {
				if(str.charAt(j) == ' ') {
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
}
