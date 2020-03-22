package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D3_3456_직사각형길이찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			HashSet<Integer> set = new HashSet<>();
			
			for(int i=0; i<3; i++){
				int value = Integer.parseInt(st.nextToken());
				
				if(set.contains(value)) set.remove(value);
				else set.add(value);
			}
			
			sb.append("#" + t + " " + set.iterator().next() + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
