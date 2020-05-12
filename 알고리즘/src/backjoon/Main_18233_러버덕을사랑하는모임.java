package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18233_러버덕을사랑하는모임 {
	public static int n, p, e;
	public static int[] numbers, x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		numbers = new int[n];
		x = new int[n];
		y = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		// n <= p라는 조건이 없으므로 p가 n보다 더 클 수도 있음 => 이 경우 n명 중 p명을 뽑는게 불가능하므로 -1
		if(p > n) {
			System.out.println("-1");
			System.exit(0);
		}
		
		for(int i=n-p; i<n; i++) {
			numbers[i] = 1;
		}
		
		boolean flag = false;	// 인형을 선물할 수 있는가?
		
		do {
			int min, max;
			min = max = 0;
			
			for(int i=0; i<n; i++) {
				if(numbers[i] == 1) {
					min += x[i];
					max += y[i];
				}
			}
			
			if(e >= min && e <= max) {
				int remain = e - min;
				
				for(int i=0; i<n; i++) {
					if(numbers[i] == 1) {
						if(remain > 0) {
							System.out.print(x[i] + Math.min(y[i] - x[i], remain) + " ");
							remain -= Math.min(y[i] - x[i], remain);
						}
						else System.out.print(x[i] + " ");
					}
					else System.out.print("0 ");
				}
				
				flag = true;
				
				break;
			}
		} while(nextPermutation());
		
		if(!flag) System.out.println("-1");
	}
	
	public static boolean nextPermutation() {
		int i = n - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		if(i==0) return false;
		
		int j = n - 1;
		while(numbers[i-1] >= numbers[j]) j--;
		
		swap(i-1, j);
		
		j = n - 1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
