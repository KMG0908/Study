package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {
	public static char[][][] cube = new char[6][3][3];
	public static char[] color = {'w', 'o', 'b', 'g', 'r', 'y'};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		for(int a=0; a<n; a++) {
			// 큐브 색 지정
			for(int c=0; c<6; c++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						cube[c][i][j] = color[c];
					}
				}
			}
			
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int b=0; b<cnt; b++) {
				String str = st.nextToken();
				boolean flag = true;
				if(str.charAt(1) == '-') flag = false;
				
				switch(str.charAt(0)) {
				case 'U':
					up(flag);
					break;
				case 'D':
					down(flag);
					break;
				case 'F':
					front(flag);
					break;
				case 'B':
					back(flag);
					break;
				case 'L':
					left(flag);
					break;
				case 'R':
					right(flag);
					break;
				}
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}
		}
	}
	
	/*   1
	 * 3 0 2
	 *   4
	 *   5
	 * */
	
	public static void up(boolean flag) {
		char[] temp = Arrays.copyOf(cube[4][0], 3);
		
		if(flag) {	// 시계 방향
			cube[4][0] = cube[2][0];
			cube[2][0] = cube[1][0];
			cube[1][0] = cube[3][0];
			cube[3][0] = temp;
		}
		else {
			cube[4][0] = cube[3][0];
			cube[3][0] = cube[1][0];
			cube[1][0] = cube[2][0];
			cube[2][0] = temp;
		}
		
		move(0, flag);
	}
	
	public static void down(boolean flag) {
		char[] temp = Arrays.copyOf(cube[4][2], 3);
		
		if(flag) {	// 시계 방향
			cube[4][2] = cube[3][2];
			cube[3][2] = cube[1][2];
			cube[1][2] = cube[2][2];
			cube[2][2] = temp;
		}
		else {
			cube[4][2] = cube[2][2];
			cube[2][2] = cube[1][2];
			cube[1][2] = cube[3][2];
			cube[3][2] = temp;
		}
		
		move(5, flag);
	}
	
	public static void front(boolean flag) {
		char[] temp = Arrays.copyOf(cube[0][2], 3);
		
		if(flag) {
			cube[0][2][0] = cube[3][2][2];
			cube[0][2][1] = cube[3][1][2];
			cube[0][2][2] = cube[3][0][2];
			
			cube[3][2][2] = cube[5][0][2];
			cube[3][1][2] = cube[5][0][1];
			cube[3][0][2] = cube[5][0][0];
			
			cube[5][0][2] = cube[2][0][0];
			cube[5][0][1] = cube[2][1][0];
			cube[5][0][0] = cube[2][2][0];
			
			cube[2][0][0] = temp[0];
			cube[2][1][0] = temp[1];
			cube[2][2][0] = temp[2];
		}
		else {
			cube[0][2][0] = cube[2][0][0];
			cube[0][2][1] = cube[2][1][0];
			cube[0][2][2] = cube[2][2][0];
			
			cube[2][0][0] = cube[5][0][2];
			cube[2][1][0] = cube[5][0][1];
			cube[2][2][0] = cube[5][0][0];
			
			cube[5][0][2] = cube[3][2][2];
			cube[5][0][1] = cube[3][1][2];
			cube[5][0][0] = cube[3][0][2];
			
			cube[3][2][2] = temp[0];
			cube[3][1][2] = temp[1];
			cube[3][0][2] = temp[2];
		}
		
		move(4, flag);
	}
	
	public static void back(boolean flag) {
		char[] temp = Arrays.copyOf(cube[0][0], 3);
		
		if(flag) {
			cube[0][0][2] = cube[2][2][2];
			cube[0][0][1] = cube[2][1][2];
			cube[0][0][0] = cube[2][0][2];
			
			cube[2][2][2] = cube[5][2][0];
			cube[2][1][2] = cube[5][2][1];
			cube[2][0][2] = cube[5][2][2];
			
			cube[5][2][0] = cube[3][0][0];
			cube[5][2][1] = cube[3][1][0];
			cube[5][2][2] = cube[3][2][0];
			
			cube[3][0][0] = temp[2];
			cube[3][1][0] = temp[1];
			cube[3][2][0] = temp[0];
		}
		else {
			cube[0][0][2] = cube[3][0][0];
			cube[0][0][1] = cube[3][1][0];
			cube[0][0][0] = cube[3][2][0];
			
			cube[3][0][0] = cube[5][2][0];
			cube[3][1][0] = cube[5][2][1];
			cube[3][2][0] = cube[5][2][2];
			
			cube[5][2][0] = cube[2][2][2];
			cube[5][2][1] = cube[2][1][2];
			cube[5][2][2] = cube[2][0][2];
			
			cube[2][2][2] = temp[2];
			cube[2][1][2] = temp[1];
			cube[2][0][2] = temp[0];
		}
		move(1, flag);
	}
	
	public static void left(boolean flag) {
		char temp1 = cube[0][0][0];
		char temp2 = cube[0][1][0];
		char temp3 = cube[0][2][0];
		
		if(flag) {
			cube[0][0][0] = cube[1][2][2];
			cube[0][1][0] = cube[1][1][2];
			cube[0][2][0] = cube[1][0][2];
			
			cube[1][2][2] = cube[5][0][0];
			cube[1][1][2] = cube[5][1][0];
			cube[1][0][2] = cube[5][2][0];
			
			cube[5][0][0] = cube[4][0][0];
			cube[5][1][0] = cube[4][1][0];
			cube[5][2][0] = cube[4][2][0];
			
			cube[4][0][0] = temp1;
			cube[4][1][0] = temp2;
			cube[4][2][0] = temp3;
		}
		else {
			cube[0][0][0] = cube[4][0][0];
			cube[0][1][0] = cube[4][1][0];
			cube[0][2][0] = cube[4][2][0];
			
			cube[4][0][0] = cube[5][0][0];
			cube[4][1][0] = cube[5][1][0];
			cube[4][2][0] = cube[5][2][0];
			
			cube[5][0][0] = cube[1][2][2];
			cube[5][1][0] = cube[1][1][2];
			cube[5][2][0] = cube[1][0][2];
			
			cube[1][2][2] = temp1;
			cube[1][1][2] = temp2;
			cube[1][0][2] = temp3;
		}
		move(3, flag);
	}
	
	public static void right(boolean flag) {
		char temp1 = cube[0][2][2];
		char temp2 = cube[0][1][2];
		char temp3 = cube[0][0][2];
		
		if(flag) {
			cube[0][2][2] = cube[4][2][2];
			cube[0][1][2] = cube[4][1][2];
			cube[0][0][2] = cube[4][0][2];
			
			cube[4][2][2] = cube[5][2][2];
			cube[4][1][2] = cube[5][1][2];
			cube[4][0][2] = cube[5][0][2];
			
			cube[5][2][2] = cube[1][0][0];
			cube[5][1][2] = cube[1][1][0];
			cube[5][0][2] = cube[1][2][0];
			
			cube[1][0][0] = temp1;
			cube[1][1][0] = temp2;
			cube[1][2][0] = temp3;
		}
		else {
			cube[0][2][2] = cube[1][0][0];
			cube[0][1][2] = cube[1][1][0];
			cube[0][0][2] = cube[1][2][0];
			
			cube[1][0][0] = cube[5][2][2];
			cube[1][1][0] = cube[5][1][2];
			cube[1][2][0] = cube[5][0][2];
			
			cube[5][2][2] = cube[4][2][2];
			cube[5][1][2] = cube[4][1][2];
			cube[5][0][2] = cube[4][0][2];
			
			cube[4][2][2] = temp1;
			cube[4][1][2] = temp2;
			cube[4][0][2] = temp3;
		}
		move(2, flag);
	}
	
	public static void move(int index, boolean flag) {
		char[][] temp = new char[3][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				temp[i][j] = cube[index][i][j];
			}
		}
		
		if(flag) {
			cube[index][0][0] = temp[2][0];
			cube[index][0][1] = temp[1][0];
			cube[index][0][2] = temp[0][0];
			
			cube[index][1][0] = temp[2][1];
			cube[index][1][1] = temp[1][1];
			cube[index][1][2] = temp[0][1];
			
			cube[index][2][0] = temp[2][2];
			cube[index][2][1] = temp[1][2];
			cube[index][2][2] = temp[0][2];
		}
		else {
			cube[index][0][0] = temp[0][2];
			cube[index][0][1] = temp[1][2];
			cube[index][0][2] = temp[2][2];
			
			cube[index][1][0] = temp[0][1];
			cube[index][1][1] = temp[1][1];
			cube[index][1][2] = temp[2][1];
			
			cube[index][2][0] = temp[0][0];
			cube[index][2][1] = temp[1][0];
			cube[index][2][2] = temp[2][0];
		}
	}
}
