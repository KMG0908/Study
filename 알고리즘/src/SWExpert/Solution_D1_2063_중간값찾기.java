package SWExpert;

import java.util.Scanner;

public class Solution_D1_2063_중간값찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[sc.nextInt()];
		
		for(int i=0; i<num.length; i++) num[i] = sc.nextInt();
		
		for(int i=num.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(num[j] > num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		
		System.out.println(num[num.length/2]);
	}
}
