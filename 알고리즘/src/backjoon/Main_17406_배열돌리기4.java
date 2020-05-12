package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	public static boolean visited[];
	public static int sequence[];
	public static int n, m, k, min = 5000, original[][], copyArr[][], lotation[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		original = new int[n][m];
		copyArr = new int[n][m];
		lotation = new int[k][3];
		visited = new boolean[k];
		sequence = new int[k];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<m; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int l=0; l<k; l++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			lotation[l][0] = Integer.parseInt(st.nextToken()) - 1;
			lotation[l][1] = Integer.parseInt(st.nextToken()) - 1;
			lotation[l][2] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(min);
	}
	
	public static void dfs(int depth) {
		if(depth == k) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					copyArr[i][j] = original[i][j];
				}
			}
			lotate();
		}
		else {
			for(int i=0; i<k; i++) {
				if(!visited[i]) {
					visited[i] = true;
					sequence[depth] = i;
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void lotate() {
		for(int l=0; l<k; l++) {
			int r = lotation[sequence[l]][0];
			int c = lotation[sequence[l]][1];
			int s = lotation[sequence[l]][2];
			
			int startX = r - s;
			int startY = c - s;
			int endX = r + s;
			int endY = c + s;
			
			while(startX != endX) {
				int temp = copyArr[startX][startY];
				
				for(int i=startX; i<endX; i++) {
					copyArr[i][startY] = copyArr[i+1][startY];
				}
				
				for(int j=startY; j<endY; j++) {
					copyArr[endX][j] = copyArr[endX][j+1];
				}
				
				for(int i=endX; i>startX; i--) {
					copyArr[i][endY] = copyArr[i-1][endY];
				}
				
				for(int j=endY; j>startY; j--) {
					if(j - 1 == startY) copyArr[startX][j] = temp;
					else copyArr[startX][j] = copyArr[startX][j-1];
				}
				
				startX++;
				startY++;
				endX--;
				endY--;
			}
		}
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			
			for(int j=0; j<m; j++) {
				sum += copyArr[i][j];
			}
			
			min = Math.min(min, sum);
		}
	}
}
