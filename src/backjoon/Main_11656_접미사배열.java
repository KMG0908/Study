package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_11656_접미사배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		
		int len = str.length();
		for(int i=0; i<len; i++) {
			list.add(str.substring(i, len));
		}
		
		Collections.sort(list);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<len; i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
