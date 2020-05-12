package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int tLength = T.length;
		int pLength = P.length;
		
		int[] fail = new int[pLength];
		for(int i=1, j=0; i<pLength; i++) {
			while(j > 0 && P[i] != P[j]) j = fail[j-1];
			
			if(P[i] == P[j]) fail[i] = ++j;
		}
		
		int cnt = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0, j=0; i<tLength; i++) {
			
			while(j > 0 && T[i] != P[j]) j = fail[j-1];
			
			if(T[i] == P[j]) {
				if(j == pLength - 1) {
					cnt++;
					sb.append((i - pLength + 2) + " ");
					j = fail[j];
				}
				else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.print(sb.toString());
	}
}
