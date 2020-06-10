package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SelectionSort {
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
		int length = number.length, temp = 0;
		
		for (int i=0; i<length; i++) {
            int min = i;

            // 최솟값 탐색
            for (int j=i+1; j<length; j++) {
                if (number[j] < number[min]) {
                    min = j;
                }
            }

            // 최솟값이 자신이면 자리 이동을 할 필요가 없음
            if (min == i) {
                continue;
            }
            
            temp = number[min];
            number[min] = number[i];
            number[i] = temp;
        }
	}
}
