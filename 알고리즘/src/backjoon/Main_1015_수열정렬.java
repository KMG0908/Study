package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1015_수열정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pair> list = new ArrayList<>();
		int[] p = new int[1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new Pair(i, v));
		}
		
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val == o2.val ? o1.idx - o2.idx : o1.val - o2.val;
			}
		});
		
		for (int i = 0; i < n; i++) {
			p[list.get(i).idx] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(p[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Pair {
		int idx;
		int val;
		
		public Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
