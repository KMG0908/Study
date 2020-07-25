package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1100_하얀칸 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean isWhite = true;
		int cnt = 0;
		
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				if(isWhite && str.charAt(j) == 'F') cnt++;
				isWhite = !isWhite;
			}
			isWhite = !isWhite;
		}
		
		System.out.println(cnt);
	}
}
