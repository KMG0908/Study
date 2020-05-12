package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_8673_코딩토너먼트1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			int k = (int)Math.pow(2, Integer.parseInt(br.readLine()));
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0; i<k; i++){
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int bored = 0;
			
			while(!queue.isEmpty()){
				int size = queue.size() / 2;

				if(size == 0) break;
				
				for(int i=0; i<size; i++){
					int a = queue.poll();
					int b = queue.poll();
					
					bored += Math.abs(a - b);
					
					queue.add(Math.max(a, b));
				}
			}

			sb.append("#" + t + " " + bored + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
