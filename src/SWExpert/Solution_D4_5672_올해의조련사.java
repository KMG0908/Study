package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_5672_올해의조련사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			
			char[] name = new char[n];
			
			for(int i=0; i<n; i++) {
				name[i] = br.readLine().trim().charAt(0);
			}
			
			StringBuilder sb = new StringBuilder();
			
			int start = 0;
			int end = n - 1;
			
			if(start == n - 1) sb.append(name[start]);
			
			while(start < end) {
				if(name[start] < name[end]) {
					sb.append(name[start++]);
				}
				else if(name[start] > name[end]) {
					sb.append(name[end--]);
				}
				else {
					int next_s = start + 1;
					int next_e = end - 1;
					
					boolean same = false;
					
					while(next_s < next_e) {
						if(name[next_s] != name[next_e]) break;
						
						if(next_s + 1 <= next_e - 1) {
							next_s++;
							next_e--;
						}
						else {
							// 남아있는 글자가 모두 같을 경우
							same = true;
							break;
						}
					}
					
					if(same) {
						for(int i=start; i<=end; i++) {
							sb.append(name[i]);
						}
						break;
					}
					else {
						if(name[next_s] < name[next_e]) {
							sb.append(name[start++]);
						}
						else {
							sb.append(name[end--]);
						}
					}
				}
				
				if(start == end) {
					sb.append(name[start]);
					break;
				}
			}
			
			System.out.println("#" + t + " " + sb.toString());
		}
	}
}
