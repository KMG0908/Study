package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1302_베스트셀러 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String book = br.readLine();
			
			if(!map.containsKey(book)) map.put(book, 1);
			else map.put(book, map.get(book) + 1);
		}
		
		String bestBook = "";
		int max = 0;
		
		for(String key : map.keySet()) {
			int value = map.get(key);
			
			if(max < value) {
				bestBook = key;
				max = value;
			}
			else if(max == value && bestBook.compareTo(key) > 0) {
				bestBook = key;
				max = value;
			}
		}
		
		System.out.println(bestBook);
	}
}
