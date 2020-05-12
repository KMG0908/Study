package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	public static int height[], n = 9;
	public static boolean visited[];
	public static int dwarf[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[9];
		dwarf = new int[7];
		visited = new boolean[9];
		
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		findDwarf(0);
		
		Arrays.sort(dwarf);
		
		for(int i=0; i<7; i++) System.out.println(dwarf[i]);
	}
	
	public static void findDwarf(int index) {
		if(index == 7) {
			int sum = 0, idx = 0;
			for(int i=0; i<9; i++) {
				if(visited[i]) {
					sum += height[i];
				}
			}
			
			if(sum == 100) {
				for(int i=0; i<9; i++) {
					if(visited[i]) {
						dwarf[idx++] = height[i];
					}
				}
			}
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				findDwarf(index + 1);
				visited[i] = false;
			}
		}
	}
}
