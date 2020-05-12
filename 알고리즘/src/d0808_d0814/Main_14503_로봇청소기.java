package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		int[][] robot = new int[1][3];
		
		st = new StringTokenizer(br.readLine(), " ");
		robot[0][0] = Integer.parseInt(st.nextToken());		// 로봇 행
		robot[0][1] = Integer.parseInt(st.nextToken());		// 로봇 열
		robot[0][2] = Integer.parseInt(st.nextToken());		// 바라보고 있는 방향
		
		int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };	// ↑ → ↓ ←
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) board[i][j] = 2;
			}
		}
		
		int nr, nc;
		int index = robot[0][2];
		int count = 0;
		int rotation = 0;	// 회전 횟수
		
		while(true) {
			if(rotation==4) {						// 후진
				nr = robot[0][0] + dir[index][0] * -1;
				nc = robot[0][1] + dir[index][1] * -1;
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) break;	// 후진이 불가능하다면 종료
				if(board[nr][nc] == 1) break;
				
				robot[0][0] = nr;
				robot[0][1] = nc;
				rotation = 0;
			}
			
			index -= 1;
			if(index < 0) index = 3;
			
			rotation++;
			
			if(board[robot[0][0]][robot[0][1]] == 2) {				// 현재 위치 청소하기
				board[robot[0][0]][robot[0][1]] = 0;
				count++;
			}
			
			nr = robot[0][0] + dir[index][0];
			nc = robot[0][1] + dir[index][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if(board[nr][nc] == 2) {								// 청소하지 않은 공간이 있다면 이동
				robot[0][0] = nr;
				robot[0][1] = nc;
				rotation = 0;
			}
		}
		
		System.out.println(count);
	}
}
