package SWExpert;

import java.util.Scanner;

public class Solution_D2_1859_백만장자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i=0; i<testCase; i++) {
			int n = sc.nextInt();
			int[] price = new int[n];
			
			for(int j=0; j<n; j++) {
				price[j] = sc.nextInt();
			}
			
			long profit = 0;
			int max = price[n-1];
			for (int j=n-2; j >= 0; j--) {
                if(max < price[j]) max = price[j];
                else profit += max - price[j];
            }
			
			/*for(int j=0; j<n-1; j++) {
				int max = price[j];
				for(int k=j+1; k<n; k++) {
					if(price[k] > max) max = price[k];
				}
				if(max - price[j] > 0) {
					profit += max - price[j];
				}
			}*/
			
			System.out.println("#" + (i+1) + " " + profit);
		}
	}
}
