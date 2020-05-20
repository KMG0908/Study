package algorithm;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = {69, 10, 30, 2, 16, 8, 31, 22};
		//int[] numbers = {1, 2, 3, 4, 5};
		//int[] numbers = {5, 4, 3, 2, 1};
		
		quickSort(numbers, 0, numbers.length-1);
		
		System.out.println(Arrays.toString(numbers));
	}
	
	public static void quickSort(int[] arr, int begin, int end) {
		if(begin < end) {
			int pivot = partition(arr, begin, end);
			quickSort(arr, begin, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	
	public static int partition(int[] arr, int begin, int end) {
		int pivot = (begin+end)/2;
		int left = begin;
		int right = end;
		
		do {
			while (arr[left] < arr[pivot] && left < right)
				left++;
			while (arr[right] >= arr[pivot] && left < right)
				right--;
			if (left < right) { // L과 R이 다른 곳에서 멈췄을 경우
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			} 
		} while (left < right);
		
		// L과 R이 만났을 경우
		int temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;
		
		return right;
	}
}
