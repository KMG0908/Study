package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D5_8191_만화책정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			int test = Integer.parseInt(br.readLine());
			
			int books[] = new int[test];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<test; i++) {
				books[i] = Integer.parseInt(st.nextToken());
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(books[0], 1);
			
			int cnt = 1;
			
			for(int i=1; i<test; i++) {
				if(!map.containsKey(books[i] - 1)) {
					cnt++;
				}
				map.put(books[i], 1);
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}
