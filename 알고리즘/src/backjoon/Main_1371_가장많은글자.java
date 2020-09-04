package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1371_가장많은글자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alphabet = new int[26];

		String input;
		while((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input, " ");
			
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				
				for(int i=0; i<str.length(); i++) {
					alphabet[str.charAt(i) - 'a']++;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<26; i++) {
			max = Math.max(max, alphabet[i]);
		}
		
		for(int i=0; i<26; i++) {
			if(alphabet[i] == max) System.out.print((char)(i + 'a'));
		}
	}
}
