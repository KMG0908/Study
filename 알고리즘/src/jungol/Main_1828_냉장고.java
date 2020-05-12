package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int refrigator = n;
		int max = list.get(0)[1];
		
		for(int i=1; i<list.size(); i++) {
			// 범위가 겹친다면 같은 냉장고 사용 가능
			if(list.get(i)[0] <= max) {
				refrigator--;
				max = Math.min(max, list.get(i)[1]);
			}
			else max = list.get(i)[1];
		}
		
		System.out.println(refrigator);
	}
}
