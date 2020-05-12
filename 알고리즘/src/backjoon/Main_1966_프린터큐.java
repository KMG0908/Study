package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] priority = new int[n];	// 각 문서에 해당하는 중요도
			int[] count = new int[10];		// 1~9 중요도의 문서가 총 몇개있는지
			Queue<Integer> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++){
				priority[i] = Integer.parseInt(st.nextToken());
				count[priority[i]]++;
				queue.offer(i);
			}
			
			int cnt = 0;
			
			while(!queue.isEmpty()){
				int order = queue.poll();
				int top = 0;
				
				// 남아있는 문서 중에 가장 중요도가 높은 것
				for(int i=9; i>0; i--){
					if(count[i] > 0){
						top = i;
						break;
					}
				}
				
				// 중요도가 가장 높은 문서라면
				if(top == priority[order]){
					// 문서 출력
					count[top]--;
					cnt++;
					// 궁금한 문서였다면 break
					if(order == m) break;
				}
				else{
					queue.offer(order);
				}
			}
			
			System.out.println(cnt);
		}
	}
}
