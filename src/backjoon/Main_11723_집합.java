package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		
		int s[] = new int[21];
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()){
			case "add":
				s[Integer.parseInt(st.nextToken())] = 1;
				break;
			case "remove":
				s[Integer.parseInt(st.nextToken())] = 0;
				break;
			case "check":
				if(s[Integer.parseInt(st.nextToken())] == 1) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "toggle":
				int num = Integer.parseInt(st.nextToken());
				s[num] = (s[num] + 1) % 2;
				break;
			case "all":
				Arrays.fill(s, 1);
				break;
			case "empty":
				Arrays.fill(s, 0);
				
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
