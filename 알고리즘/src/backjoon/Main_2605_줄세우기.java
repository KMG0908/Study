package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			list.add(i - Integer.parseInt(st.nextToken()), i + 1);
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(sb.toString());
	}
}
