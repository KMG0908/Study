package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2864_5와6의차이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		String max_a = a.replaceAll("5|6", "6");
		String max_b = b.replaceAll("5|6", "6");
		
		String min_a = a.replaceAll("5|6", "5");
		String min_b = b.replaceAll("5|6", "5");
		
		int min = Integer.parseInt(min_a) + Integer.parseInt(min_b);
		int max = Integer.parseInt(max_a) + Integer.parseInt(max_b);
		
		System.out.println(min + " " + max);
	}
}
