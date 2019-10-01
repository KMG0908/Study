package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_6549_히스토그램_스택 {
	public static long[] width;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			int[] rectangle = new int[n];
			width = new long[n];
			
			for(int i=0; i<n; i++) {
				rectangle[i] = Integer.parseInt(st.nextToken());
			}
			
			Stack<Integer> stack = new Stack<>();
			
			long size = 0;
			
			stack.push(0);
			
			for(int i=1; i<n; i++) {
				while(!stack.isEmpty() && rectangle[stack.peek()] > rectangle[i]) {
					long width = i;
					int top = stack.peek();
					stack.pop();

					if(!stack.isEmpty()) width = i - stack.peek() - 1;
					
					size = Math.max(size, width * rectangle[top]);
				}
				stack.push(i);
			}
			
			while(!stack.isEmpty()) {
				long width = n;
				int top = stack.peek();
				stack.pop();
				
				if(!stack.isEmpty()) width = n - stack.peek() - 1;
				
				size = Math.max(size, width * rectangle[top]);
			}
			
			System.out.println(size);
		}
	}
}
