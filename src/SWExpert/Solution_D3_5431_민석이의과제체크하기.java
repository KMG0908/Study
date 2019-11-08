package SWExpert;

import java.util.Scanner;

public class Solution_D3_5431_민석이의과제체크하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i=0; i<testCase; i++) {
			int students = sc.nextInt();		// 수강생 수
			int submitStudents = sc.nextInt();	// 과제를 제출한 사람 수
			int[] isSubmit = new int[students];
			
			for(int j=0; j<submitStudents; j++) {
				isSubmit[sc.nextInt() - 1] = 1;
			}
			
			System.out.print("#" + (i+1) + " ");
			
			for(int j=0; j<isSubmit.length; j++) {
				if(isSubmit[j] == 0) System.out.print(j+1 + " ");
			}
			
			System.out.println();
		}
	}
}