package SWExpert;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			
			for(int j=0; j<100; j++) {
				box[j] = sc.nextInt();
			}
			
			Arrays.sort(box);
			
			while(dump > 0) {
				if(box[99] - box[0] <= 1) break;
				box[99]--;
				box[0]++;
				dump--;
				Arrays.sort(box);
			}
			
			System.out.println("#" + (i+1) + " " + (box[99] - box[0]));
		}
	}
}
