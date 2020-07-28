package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1159_농구경기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] name = new String[n];
		
		for(int i=0; i<n; i++) {
			name[i] = br.readLine();
		}
		
		Arrays.sort(name);
		
		int cnt = 1;
		char first = name[0].charAt(0);
		ArrayList<Character> list = new ArrayList<>();
		for(int i=1; i<n; i++) {
			if(first != name[i].charAt(0)) {
				first = name[i].charAt(0);
				cnt = 1;
			}
			else {
				cnt++;
				if(cnt >= 5 && !list.contains(first)) {
					list.add(first);
				}
			}
		}
		
		if(list.size() == 0) System.out.println("PREDAJA");
		else {
			for(int i=0; i<list.size(); i++) System.out.print(list.get(i));
		}
	}
}
