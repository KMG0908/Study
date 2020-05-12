package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int i=1; i<=n; i++) {
			stack.push(i);
			sb.append("+\n");
			
			while(!stack.isEmpty() && stack.peek() == arr[j]) {
				stack.pop();
				sb.append("-\n");
				j++;
			}
		}
		
		if(!stack.isEmpty()) System.out.println("NO");
		else System.out.println(sb.toString());
	}
}
