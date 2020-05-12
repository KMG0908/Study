package SWExpert;

import java.util.Scanner;

public class Solution_D2_1926_간단한369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean flag = false;
		for(int i=1; i<=n; i++) {
			if(i >= 10) flag = true;
			
			if(flag) {
				String[] arr = String.valueOf(i).split("");
				int[] num = new int[arr.length];
						
				for(int j=0; j<arr.length; j++) num[j] = Integer.parseInt(arr[j]);
				
				int count = 0;
				for(int j=0; j<num.length; j++) {
					if(num[j]!=0 && num[j]%3 == 0) System.out.print("-");
					else count++;
				}
				
				if(count == num.length) System.out.print(i);
				
				System.out.print(" ");
			}
			else {
				if(i%3!=0) System.out.print(i);
				else System.out.print("-");
				
				System.out.print(" ");
			}
		}
	}
}
