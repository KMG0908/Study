package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1076_저항 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] color = {"black", "brown", "red", "orange", "yellow", "green",
				"blue", "violet", "grey", "white"};
		
		HashMap<String, Integer> val = new HashMap<>();
		HashMap<String, Integer> mul = new HashMap<>();
		
		for(int i=0; i<color.length; i++) {
			val.put(color[i], i);
			mul.put(color[i], (int)Math.pow(10, i));
		}
		
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		long res = (long)(val.get(first) * 10 + val.get(second)) * mul.get(third);
		
		System.out.println(res);
	}
}
