package SWExpert;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] count = new int[testCase];
		
		for(int i=0; i<testCase; i++) {
			String[] bit = String.valueOf(sc.next()).split("");
			int[] originalBit = new int[bit.length];
			
			for(int j=0; j<bit.length; j++) originalBit[j] = Integer.parseInt(bit[j]);
			
			int[] resetBit = new int[bit.length];
			
			for(int j=0; j<bit.length; j++) {
				if(originalBit[j] != resetBit[j]) {
					for(int k=j; k<bit.length; k++) {
						resetBit[k] = originalBit[j];
					}
					count[i]++;
				}
				
				if(Arrays.equals(originalBit, resetBit)) break;
			}
		}
		
		for(int i=0; i<count.length; i++) System.out.printf("#%d %d\n", i+1, count[i]);
	}
}
