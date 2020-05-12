package d1001_d1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 문제 푼 시간: 57분
 */
public class Main_1654_랜선자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] line = new int[k];
		
		for(int i=0; i<k; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(line);
		
		long start = 1;
		long end = line[k-1];
		long mid = 0;
		
		while(end >= start) {
			mid = (start + end) / 2;
			
			int cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += line[i] / mid;
			}
			
			if(cnt < n) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
			
		System.out.println(end);
	}
}
