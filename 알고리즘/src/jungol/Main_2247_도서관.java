package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2247_도서관 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int students[][] = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			students[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		Arrays.sort(students, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int min = students[0][0];
		int max = students[0][1];
		int stay = 0;
		int leave = 0;
		
		for(int i=0; i<n; i++) {
			if(students[i][0] <= max) {
				min = Math.min(min, students[i][0]);
				max = Math.max(max, students[i][1]);
			}
			else {
				stay = Math.max(stay, max - min);
				leave = Math.max(leave, students[i][0] - max);
				min = students[i][0];
				max = students[i][1];
			}
		}
		
		stay = Math.max(stay, max - min);
		
		System.out.println(stay + " " + leave);
	}
}
