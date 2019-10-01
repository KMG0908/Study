package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값_try_catch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		
		try {
			for(int i=0; i<arr.length; i++) {
				switch(arr[i]) {
				case "(":
					stack.push(arr[i]);
					break;
				case ")":
					if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {	// 숫자가 있다면
						int p = Integer.parseInt(stack.pop());	
						if(stack.peek().equals("(")) {		// ex. (10)			(10) => 20
							stack.pop();
							p *= 2;	
							while(!stack.isEmpty()) {
								// ex. 2(10)		2(10) => 2 + 2 * 10
								if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
									p += Integer.parseInt(stack.pop());		// 더해주기
								}
								else break;
							}
							stack.push(String.valueOf(p));	// 숫자 넣어주기
						}
					}
					else if(stack.peek().equals("(")) {		// ex. ()			() => 2
						stack.pop();
						int p = 2;
						while(!stack.isEmpty()) {
							// ex. 4()		4() => 4 + 2
							if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
								p += Integer.parseInt(stack.pop());
							}
							else break;
						}
						stack.push(String.valueOf(p));
					}
					
					break;
				case "[":
					stack.push(arr[i]);
					break;
				case "]":
					if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
						int p = Integer.parseInt(stack.pop());
						if(stack.peek().equals("[")) {
							stack.pop();
							p *= 3;
							while(!stack.isEmpty()) {
								if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
									p += Integer.parseInt(stack.pop());
								}
								else break;
							}
							stack.push(String.valueOf(p));
						}
					}
					else if(stack.peek().equals("[")) {
						stack.pop();
						int p = 3;
						while(!stack.isEmpty()) {
							if(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
								p += Integer.parseInt(stack.pop());
							}
							else break;
						}
						stack.push(String.valueOf(p));
					}
					
					break;
				}
				//System.out.println(stack);
			}
		} catch(Exception e) {
			System.out.println("0");
			return;
		}
		
		if(stack.size() == 1 && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') System.out.println(stack.pop());
		else System.out.println("0");
	}
}
