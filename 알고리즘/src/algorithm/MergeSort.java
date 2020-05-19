package algorithm;

import java.util.Arrays;

public class MergeSort {
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
	
	public static void main(String[] args) {
		int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
		System.out.println(Arrays.toString(mergeSort(list)));
	}
}
