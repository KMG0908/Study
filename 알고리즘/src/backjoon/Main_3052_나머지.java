package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] visited = new boolean[42];
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			
			visited[num % 42] = true;
		}
		
		int cnt = 0;
		for(int i=0; i<42; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt);
	}
}
