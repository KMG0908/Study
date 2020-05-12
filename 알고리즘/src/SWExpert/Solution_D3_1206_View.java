package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
	public static int n, height[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=10; t++) {
			n = Integer.parseInt(br.readLine());
			height = new int[n+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=2; i<n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i=2; i<n; i++) {
				cnt += check(i);
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int check(int i) {
		if(height[i] < height[i-2] || height[i] < height[i-1] || 
				height[i] < height[i+1] || height[i] < height[i+2]) return 0;
		
		int left = Math.max(height[i-2], height[i-1]);
		int right = Math.max(height[i+1], height[i+2]);
		int max = Math.max(left, right);
		
		return height[i] - max;
	}
}
