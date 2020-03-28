package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] state = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++){
			state[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		int[][] s_info = new int[student][2];
		
		for(int i=0; i<student; i++){
			st = new StringTokenizer(br.readLine());
			s_info[i][0] = Integer.parseInt(st.nextToken());
			s_info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<student; i++){
			switch(s_info[i][0]){
			case 1:
				for(int j=s_info[i][1]; j<=n; j+=s_info[i][1]){
					state[j] = (state[j] + 1) % 2;
				}
				
				break;
			case 2:
				int center = s_info[i][1];
				int left = center - 1;
				int right = center + 1;
				
				state[center] = (state[center] + 1) % 2;
				
				while(left >= 1 && right <= n){
					if(state[left] != state[right]) break;
					
					state[left] = (state[left] + 1) % 2;
					state[right] = (state[right] + 1) % 2;
					left--;
					right++;
				}
				
				break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=n; i++){
			sb.append(state[i] + " ");
			if(i % 20 == 0) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
