package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int moveX = Math.abs(x2 - x1);
			int moveY = Math.abs(y2 - y1);
			
			int ans = 0;
			
			// x축으로 이동해야 하는 횟수와 y축으로 이동해야 하는 횟수가 같을 경우
			if(moveX == moveY){
				ans = moveX * 2;
			}
			else{
				ans = Math.min(moveX, moveY) * 2;
				
				int move = Math.abs(moveX - moveY);
				
				// 짝수번 더 움직여야 할 경우는 세로, 가로, ..., 세로, 가로  이런 식으로 move의 2배만큼 움직이면 됨
				if(move % 2 == 0){
					ans += 2 * move;
				}
				// 홀수번 더 움직여야 할 경우에는 세로, 가로, ..., 세로 혹은 가로, 세로, ..., 가로 식으로 움직여야 함으로
				// move의 2배만큼 움직인 것에서 1을 빼줘야 함
				else{
					ans += 2 * move - 1;
				}
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
