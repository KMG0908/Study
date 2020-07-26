package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1145_적어도대부분의배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = 1;
		
		while(true) {
			int cnt = 0;
			
			for(int i=0; i<5; i++) {
				if(num % arr[i] == 0) cnt++;
			}
			
			if(cnt >= 3) {
				System.out.println(num);
				break;
			}
			
			num++;
		}
	}
}
