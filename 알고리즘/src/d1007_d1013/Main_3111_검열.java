package d1007_d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3111_검열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String T = br.readLine();
		
		int start = 0;
		int end = T.length() - 1;
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		boolean remove = false;
		
		int size = A.length();
		
		while(start <= end) {
			if(!remove) {
				left.push(T.charAt(start++));
				
				if(left.size() >= size && left.peek() == A.charAt(size - 1)) {
					int idx = 0;
					boolean flag = true;
					for(int i=left.size()-size; i<left.size()-1; i++) {
						if(left.get(i) != A.charAt(idx++)) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						for(int i=0; i<size; i++) left.pop();
						remove = true;
					}
				}
			}
			else {
				right.push(T.charAt(end--));
				
				if(right.size() >= size && right.peek() == A.charAt(0)) {
					int idx = 0;
					boolean flag = true;
					for(int i=right.size()-1; i>=right.size()-size; i--) {
						if(right.get(i) != A.charAt(idx++)) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						for(int i=0; i<size; i++) right.pop();
						remove = false;
					}
				}
			}
		}
		
		while(left.size() != 0) {
			right.push(left.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(right.size() != 0) {
			sb.append(right.pop());
		}
		
		// 텍스트를 왼쪽, 오른쪽 순서대로 훑었으므로 합쳤을 때 A는 최대 한 번만 생성됨
		// 다만, A를 지웠을 때 또다시 A가 생길 가능성이 존재하므로 A가 없을 때까지 확인해줘야 함
		while(true) {
			int idx = sb.indexOf(A);
			if(idx == -1) break;
			sb.delete(idx, idx + size);
		}
		
		System.out.println(sb.toString());
	}
}
