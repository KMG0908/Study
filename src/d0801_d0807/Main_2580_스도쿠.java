package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	static int[][] sudoku = new int[9][9];
	static ArrayList<Integer> row = new ArrayList<>();		// 0인 좌표의 행
	static ArrayList<Integer> col = new ArrayList<>();		// 0인 좌표의 열
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(sudoku[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		
		fillZero(0);
	}
	
	public static void fillZero(int index) {
		if(index >= row.size()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			
			flag = false;
			
			return;
		}
		
		int r = row.get(index);
		int c = col.get(index);
		
		for(int i=1; i<=9 && flag; i++) {
			sudoku[r][c] = i;						// 1~9 숫자 넣어보기			
			if(possible(r, c)) fillZero(index + 1);		// 가로, 세로, 3*3 구역에서 숫자가 겹치지 않는다면 다음 0 채우기
			sudoku[r][c] = 0;
		}
	}

	private static boolean possible(int r, int c) {
		for(int i=0; i<9; i++) {							// 세로 라인 검사
			if(r == i) continue;
			if(sudoku[r][c] == sudoku[i][c]) return false;
		}
		
		for(int j=0; j<9; j++) {							// 가로 라인 검사
			if(c == j) continue; 
			if(sudoku[r][c] == sudoku[r][j]) return false;
		}
		
		int iStart = r / 3 * 3;
		int iEnd = iStart + 3;
		int jStart = c / 3 * 3;
		int jEnd = jStart + 3;
		for(int i=iStart; i<iEnd; i++) {					// 3 * 3 구역 검사
			for(int j=jStart; j<jEnd; j++) {
				if(r == i && c == j) continue;
				if(sudoku[r][c] == sudoku[i][j]) return false;
			}
		}
		
		return true;
	}
}
