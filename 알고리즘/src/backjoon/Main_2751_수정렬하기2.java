package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] result = mergeSort(numbers);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			sb.append(result[i] + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static int[] mergeSort(int[] list) {
		if(list.length <= 1) return list;
		
		int middle = list.length / 2;
		
		int[] left, right;
		
		if(list.length % 2 == 0) {
			left = new int[middle];
			right = new int[middle];
		}
		else {
			left = new int[middle];
			right = new int[middle + 1];
		}
		
		for(int i=0; i<left.length; i++) {
			left[i] = list[i];
		}
		
		for(int i=middle; i<list.length; i++) {
			right[i-middle] = list[i];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while(leftIndex < left.length|| rightIndex < right.length) {
			if(leftIndex < left.length && rightIndex < right.length) {
				if(left[leftIndex] <= right[rightIndex]) {
					result[resultIndex++] = left[leftIndex++];
				}
				else {
					result[resultIndex++] = right[rightIndex++];
				}
			}
			else if(leftIndex < left.length) {
				result[resultIndex++] = left[leftIndex++];
			}
			else if(rightIndex < right.length) {
				result[resultIndex++] = right[rightIndex++];
			}
		}
		
		return result;
	}
}
