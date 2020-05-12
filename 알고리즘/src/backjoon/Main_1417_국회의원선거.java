package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1417_국회의원선거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dasom = Integer.parseInt(br.readLine());
		int arr[] = new int[n-1];
		
		for(int i=0; i<n-1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 0;
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			if(n == 1) break;
				
			Arrays.sort(arr);
			
			boolean flag = true;
			
			int last = n - 2;
			
			if(dasom <= arr[n - 2]) {
				dasom++;
				arr[last]--;
				min++;
				flag = false;
			}
			
			if(flag) break;
		}
		
		if(n == 1) sb.append("0");
		else sb.append(min);
		
		System.out.println(sb.toString());
	}
}
