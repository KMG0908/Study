package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] tops = new int[n];
		int[] receive = new int[n];
		
		Stack<Integer> index = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		/*for(int i=n-1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(tops[i] < tops[j]) {
					receive[i] = j+1;
					break;
				}
			}
		}
		
		for(int i=0; i<receive.length; i++) {
			System.out.print(receive[i] + " ");
		}
		System.out.println();*/
		
		for(int i=0; i<n; i++) {
			if(index.isEmpty()) {
				index.push(i);
				receive[i] = 0;
			}
			else if(tops[index.peek()] > tops[i]) {
				receive[i] = index.peek() + 1;
				index.push(i);
			}
			else {
				while(true) {
					index.pop();
					
					if(index.isEmpty()) {
						index.push(i);
						receive[i] = 0;
						break;
					}
					
					if(tops[index.peek()] > tops[i]) {
						receive[i] = index.peek() + 1;
						index.push(i);
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<receive.length; i++) {
			sb.append(receive[i] + " ");
		}
		System.out.println(sb);
	}
}
