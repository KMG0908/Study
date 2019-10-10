package d1007_d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16939_2x2x2큐브 {
	public static int cube[][][] = new int[6][2][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int k=0; k<6; k++) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					cube[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		if(up()) {
			System.out.println("up");
			System.out.println("1");
		}
		else if(down()) {
			System.out.println("down");
			System.out.println("1");
		}
		else if(right()) {
			System.out.println("right");
			System.out.println("1");
		}
		else if(left()) {
			System.out.println("left");
			System.out.println("1");
		}
		else System.out.println("0");
	}
	
	/*
	 *  0
	 *3 1 4 5
	 *  2
	 */
	
	public static boolean up() {
		int[][][] copy = copy();
		
		int[] temp = new int[2];
		temp[0] = copy[1][0][1];
		temp[1] = copy[1][1][1];
		
		copy[1][0][1] = copy[2][0][1];
		copy[1][1][1] = copy[2][1][1];
		
		copy[2][0][1] = copy[5][1][0];
		copy[2][1][1] = copy[5][0][0];
		
		copy[5][1][0] = copy[0][0][1];
		copy[5][0][0] = copy[0][1][1];
		
		copy[0][0][1] = temp[0];
		copy[0][1][1] = temp[1];
		
		if(check(copy)) return true;
		
		return false;
	}
	
	public static boolean down() {
		int[][][] copy = copy();
		
		int[] temp = new int[2];
		temp[0] = copy[1][0][1];
		temp[1] = copy[1][1][1];
		
		copy[1][0][1] = copy[0][0][1];
		copy[1][1][1] = copy[0][1][1];
		
		copy[0][0][1] = copy[5][1][0];
		copy[0][1][1] = copy[5][0][0];
		
		copy[5][1][0] = copy[2][0][1];
		copy[5][0][0] = copy[2][1][1];
		
		copy[2][0][1] = temp[0];
		copy[2][1][1] = temp[1];
		
		if(check(copy)) return true;
		
		return false;
	}
	
	public static boolean right() {
		int[][][] copy = copy();
		
		int[] temp = new int[2];
		temp[0] = copy[2][0][0];
		temp[1] = copy[2][0][1];
		
		copy[2][0][0] = copy[3][0][1];
		copy[2][0][1] = copy[3][1][1];
		
		copy[3][0][1] = copy[0][1][1];
		copy[3][1][1] = copy[0][1][0];
		
		copy[0][1][1] = copy[4][1][0];
		copy[0][1][0] = copy[4][0][0];
		
		copy[4][1][0] = temp[0];
		copy[4][0][0] = temp[1];
		
		if(check(copy)) return true;
		
		return false;
	}
	
	public static boolean left() {
		int[][][] copy = copy();
		
		int[] temp = new int[2];
		temp[0] = copy[2][0][0];
		temp[1] = copy[2][0][1];
		
		copy[2][0][0] = copy[4][1][0];
		copy[2][0][1] = copy[4][0][0];
		
		copy[4][1][0] = copy[0][1][1];
		copy[4][0][0] = copy[0][1][0];
		
		copy[0][1][1] = copy[3][0][1];
		copy[0][1][0] = copy[3][1][1];
		
		copy[3][0][1] = temp[0];
		copy[3][1][1] = temp[1];
		
		if(check(copy)) return true;
		
		return false;
	}
	
	public static boolean check(int[][][] copy) {
		for(int k=0; k<6; k++) {
			boolean[] color = new boolean[6];
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					color[copy[k][i][j] - 1] = true;
				}
			}
			
			int cnt = 0;
			for(int i=0; i<6; i++) {
				if(color[i]) cnt++;
			}
			
			if(cnt != 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[][][] copy(){
		int[][][] copy = new int[6][2][2];
		
		for(int k=0; k<6; k++) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					copy[k][i][j] = cube[k][i][j];
				}
			}
		}
		
		return copy;
	}
}
