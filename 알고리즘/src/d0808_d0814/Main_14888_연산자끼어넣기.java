package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼어넣기 {
	public static int n;
	public static int[] numbers;
	public static String[] operator, operArr;
	public static boolean[] visited;
	public static int max = -1000000000;
	public static int min = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];					// 숫자 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new String[n-1];				// 가능한 연산자 배열
		operArr = new String[n-1];				// 연산자 배열 조합
		visited = new boolean[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		
		int index = 0;
		int operIndex = 0;		// 0: +, 1: -, 2: *, 3: /
		String[] operStr = {"+", "-", "*", "/"};
		
		for(int i=0; i<4; i++) {
			int operNum = Integer.parseInt(st.nextToken());
			for(int j=0; j<operNum; j++) {
				operator[index++] = operStr[operIndex];
			}
			operIndex++;
		}
		
		oper(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void oper(int index) {
		if(index == n-1) {
			int result = numbers[0];
			
			for(int i=0; i<n-1; i++) {
				switch(operArr[i]) {
				case "+":
					result += numbers[i+1];
					break;
				case "-":
					result -= numbers[i+1];
					break;
				case "*":
					result *= numbers[i+1];
					break;
				case "/":
					result /= numbers[i+1];
					break;
				}
			}
			
			if(result > max) max = result;
			if(result < min) min = result;

			return;
		}
		
		for(int i=0; i<n-1; i++) {
			if(!visited[i]) {
				operArr[i] = operator[index];
				visited[i] = true;
				oper(index + 1);
				visited[i] = false;
			}
		}
	}
}
