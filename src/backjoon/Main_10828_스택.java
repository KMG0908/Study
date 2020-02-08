package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()){
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop() + "\n");
				break;
			case "size":
				sb.append(stack.size() + "\n");
				break;
			case "empty":
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "top":
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek() + "\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
