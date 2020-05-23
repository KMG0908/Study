package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] number = new int[N];
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(number);
		System.out.println(Arrays.toString(number));
		
	}
	
	public static void sort(int[] number) {
		int size = number.length, temp = 0;
		
		for(int i=size-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(number[j] > number[j+1]) {
					temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
				}
			}
		}
	}
}
