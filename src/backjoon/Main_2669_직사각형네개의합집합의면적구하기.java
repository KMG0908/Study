package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean visited[][] = new boolean[101][101];
		
		for(int n=0; n<4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					visited[i][j] = true;
				}
			}
		}
		
		int area = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(visited[i][j]) area++;
			}
		}
		
		System.out.println(area);
	}
}
