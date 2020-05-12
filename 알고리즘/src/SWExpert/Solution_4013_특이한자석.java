package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_4013_특이한자석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int k = Integer.parseInt(br.readLine());
			
			int[][] wheels = new int[4][8];
			
			for(int i=0; i<4; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					wheels[i][j] = str.charAt(j * 2) - '0';
				}
			}
			
			for(int command=0; command<k; command++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				int left = num, right = num;
				
				// 왼쪽 어디까지 회전해야 하는지
				for(int i=num-1; i>=0; i--) {
					if(wheels[i+1][6] != wheels[i][2]) {
						left = i;
						dir *= -1;
					}
					else break;
				}
				
				// 오른쪽 어디까지 회전해야 되는지
				for(int i=num+1; i<4; i++) {
					if(wheels[i-1][2] != wheels[i][6]) {
						right = i;
					}
					else break;
				}
				
				for(int i=left; i<=right; i++) {
					if(dir == 1) {
						int temp = wheels[i][7];
						for(int j=7; j>0; j--) {
							wheels[i][j] = wheels[i][j-1];
						}
						wheels[i][0] = temp;
					}
					else {
						int temp = wheels[i][0];
						for(int j=0; j<7; j++) {
							wheels[i][j] = wheels[i][j+1];
						}
						wheels[i][7] = temp;
					}
					
					dir *= -1;
				}
				
				/*for(int i=0; i<4; i++) {
					System.out.println(Arrays.toString(wheels[i]));
				}
				System.out.println();*/
			}
			
			int score = 0;
			if(wheels[0][0] == 1) score += 1;
			if(wheels[1][0] == 1) score += 2;
			if(wheels[2][0] == 1) score += 4;
			if(wheels[3][0] == 1) score += 8;
			
			System.out.println("#" + t + " " + score);
		}
	}
}