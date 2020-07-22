package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	public static int[] king, rock;
	public static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
	public static HashMap<String, Integer> strToInt = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		king = new int[2];
		rock = new int[2];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String kingStr = st.nextToken();
		String rockStr = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		
		king[0] = kingStr.charAt(0) - 'A';
		king[1] = kingStr.charAt(1) - '1';
		rock[0] = rockStr.charAt(0) - 'A';
		rock[1] = rockStr.charAt(1) - '1';
		
		String[] dirStr = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
		for(int i=0; i<8; i++) {
			strToInt.put(dirStr[i], i);
		}
		
		for(int i=0; i<n; i++) {
			go(br.readLine());
		}
	
		System.out.print((char)(king[0] + 'A'));
		System.out.println(king[1] + 1);
		System.out.print((char)(rock[0] + 'A'));
		System.out.println(rock[1] + 1);
	}
	
	public static void go(String direction) {
		int i = strToInt.get(direction);
		
		int kingX = king[0] + dir[i][0];
		int kingY = king[1] + dir[i][1];
		
		if(kingX == rock[0] && kingY == rock[1]) {
			int rockX = rock[0] + dir[i][0];
			int rockY = rock[1] + dir[i][1];
			
			if(check(rockX, rockY)) {
				king[0] = kingX;
				king[1] = kingY;
				rock[0] = rockX;
				rock[1] = rockY;
			}
		}
		else {
			if(check(kingX, kingY)) {
				king[0] = kingX;
				king[1] = kingY;
			}
		}
	}
	
	public static boolean check(int x, int y) {
		if(x >= 0 && x < 8 && y >= 0 && y < 8) return true;
		return false;
	}
}
