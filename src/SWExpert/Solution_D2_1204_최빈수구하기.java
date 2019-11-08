package SWExpert;

import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int i=0; i<testCase; i++) {
			int testCaseNum = sc.nextInt();
			int[] score = new int[101];
			
			for(int j=0; j<1000; j++) score[sc.nextInt()]++;
			
			int maxScore = 0;
			int maxCount = 0;
			for(int j=0; j<score.length; j++) {
				if(score[j] >= maxCount) {
					maxCount = score[j];
					maxScore = j;
				}
			}
			
			System.out.println("#" + testCaseNum + " " + maxScore);
		}
	}
}
