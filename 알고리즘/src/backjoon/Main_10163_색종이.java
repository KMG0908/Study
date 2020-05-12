package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[101][101];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+w; j++) {
				for(int k=y; k<y+h; k++) {
					paper[j][k] = i + 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			
			for(int j=0; j<101; j++) {
				for(int k=0; k<101; k++) {
					if(paper[j][k] == i + 1) cnt++; 
				}
			}
			
			System.out.println(cnt);
		}
	}
}
