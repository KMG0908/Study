package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455_지능형기차 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 0, person = 0;
		
		for(int i=0; i<4; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			person += -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			
			max = Math.max(max, person);
		}
		
		System.out.println(max);
	}
}
