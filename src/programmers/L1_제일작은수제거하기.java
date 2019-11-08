package programmers;

import java.util.Arrays;

public class L1_제일작은수제거하기 {
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		int[] answer = {};
		
		int[] sort = new int[arr.length];
		
		for(int i=0; i<sort.length; i++) sort[i] = arr[i];
		
		Arrays.sort(sort);
		
		if(arr.length - 1 == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		else {
			answer = new int[arr.length - 1];
		}
		
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != sort[0]) answer[index++] = arr[i];
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
