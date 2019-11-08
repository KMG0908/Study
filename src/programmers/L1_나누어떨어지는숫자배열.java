package programmers;

import java.util.Arrays;

public class L1_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		int[] answer = {};
		
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%divisor == 0) cnt++;
		}
		
		if(cnt == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		else answer = new int[cnt];
		
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%divisor == 0) answer[index++] = arr[i];
		}
		
		Arrays.sort(answer);
	}
}
