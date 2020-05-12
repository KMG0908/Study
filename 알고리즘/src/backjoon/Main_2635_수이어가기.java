package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int arr[] = new int[100];
		int ans[] = new int[100];
		
		for(int i=n/2; i<=n; i++) {
			int cnt = 1;
			arr[0] = n;
			arr[1] = i;
			int dif = arr[0] - arr[1];
			int idx = 2;
			
			while(dif >= 0) {
				arr[idx] = arr[idx - 2] - arr[idx - 1];
				dif = arr[idx];
				idx++;
				cnt++;
			}
			
			if(cnt > max) {
				max = cnt;
				ans = Arrays.copyOf(arr, max);
			}
		}
		
		System.out.println(max);
		for(int i=0; i<max; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}
