package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int testCase = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cycle = 1;
			
			while(true) {
				int num = queue.poll() - cycle;
				if(num <= 0) num = 0;
				queue.offer(num);
				
				if(num == 0) break;
				
				cycle++;
				if(cycle == 6) cycle = 1;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " ");
			
			for(int i=0; i<8; i++) {
				sb.append(queue.poll() + " ");
			}
			
			System.out.println(sb);
		}
	}
}
