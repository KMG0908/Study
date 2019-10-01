package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] test = new int[n];
		int general = 0, deputy = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		general = Integer.parseInt(st.nextToken());
		deputy = Integer.parseInt(st.nextToken());
		
		long count = 0;			// int로 할 시 범위를 벗어나서 실패하는 듯....
		
		for(int i=0; i<n; i++) {
			if(general >= test[i]) {		// 총 감독관이 시험장 한개를 커버할 수 있는 경우 다음 케이스로 넘어가기
				count++;
				continue;
			}
			
			/* 총 감독관이 커버하지 못하는 인원을 나머지 부 감독관이 커버. 
			 * count는 총 감독관 1명 + 부 감독관이 필요한 만큼 더해줌.
			 * 나눴을 때 나머지가 있을 경우에는 인원수가 남은 것이므로 부 감독관이 한 명 더 필요하므로 if문으로 분리.
			 */
			if((test[i] - general) % deputy == 0) count += 1 + (test[i] - general) / deputy;
			else count += 1 + (test[i] - general) / deputy + 1;
		}
		
		System.out.println(count);
	}
}
