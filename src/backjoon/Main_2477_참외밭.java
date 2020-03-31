package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int w = 0, h = 0;
		int sub_w = 0, sub_h = 0;
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(i % 2 == 0) w = Math.max(w, arr[i]);
			else h = Math.max(h, arr[i]);
		}
		
		// 자신을 기준으로 앞의 변과 뒤의 변을 더했을 때 너비 혹은 높이라면 그 변은 파인 부분의 변임
		for(int i=0; i<6; i++) {
			if(i % 2 == 0) {
				if(h == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
					sub_w = arr[i];
				}
			}
			else {
				if(w == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
					sub_h = arr[i];
				}
			}
		}
		
		System.out.println((w * h - sub_w * sub_h) * k);
	}
}
