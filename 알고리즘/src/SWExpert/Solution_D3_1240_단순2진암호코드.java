package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] encryption = new int[n][m];
			
			int startIdx = 0, endIdx = 0;
			
			int beforeSum = 0;
			
			for(int i=0; i<n; i++) {
				int sum = 0;
				String line = br.readLine();
				for(int j=0; j<m; j++) {
					encryption[i][j] = line.charAt(j) - '0';
					sum += encryption[i][j];
				}
				
				if(startIdx == 0 && sum != 0) {
					startIdx = i;
				}
				
				if(beforeSum != 0 && sum == 0) {
					endIdx = i;
				}
				
				beforeSum = sum;
			}
			
			int start = 0;
			
			out:
			for(int i=startIdx; i<n; i++) {
				next:
				for(int j=0; j<m; j++) {
					String str = "";
					for(int k=j; k<j+7 && j+7<m; k++) {
						str += encryption[i][k];
					}
					if(map.containsKey(str)) {
						if(start == 0) start = j;
						
						for(int k=j+7; k<j+49; k+=7) {
							str = "";
							for(int l=k; l<k+7; l++) {
								str += encryption[i][l];
							}
							if(map.containsKey(str)) continue;
							else {
								start = 0;
								continue next;
							}
						}
						
						break out;
					}
				}
			}
			
			int end = start + 56;
			
			int total = 0;
			
			for(int i=startIdx; i<endIdx; i++) {
				int[] numbers = new int[8];
				int idx = 0;
				for(int j=start; j<end; j+=7) {
					String str = "";
					for(int k=j; k<j+7; k++) {
						str += encryption[i][k];
					}
					numbers[idx++] = map.get(str);
				}
				
				int check = (numbers[0] + numbers[2] + numbers[4] + numbers[6]) * 3 + 
						(numbers[1] + numbers[3] + numbers[5]) + numbers[7];
				if(check % 10 == 0) {
					total = 0;
					for(int j=0; j<8; j++) {
						total += numbers[j];
					}
				}
				else {
					total = 0;
					break;
				}
			}
			
			System.out.println("#" + t + " " + total);
		}
	}
}
