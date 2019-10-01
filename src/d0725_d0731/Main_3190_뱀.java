package d0725_d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 보드 크기
		int[][] board = new int[N][N];
		board[0][0] = 1;
		
		int K = Integer.parseInt(br.readLine());		// 사과 개수
		int[][] apple = new int[K][2];
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			apple[i][0] = Integer.parseInt(st.nextToken());		// 사과 위치 행
			apple[i][1] = Integer.parseInt(st.nextToken());		// 사과 위치 열
			board[apple[i][0] - 1][apple[i][1] - 1] = 2;
		}
		
		int D = Integer.parseInt(br.readLine());		// 방향 변환 횟수
		
		String[][] d_info = new String[D][2];
		
		for(int i=0; i<D; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			d_info[i][0] = st.nextToken();				// X 초가 흐른뒤
			d_info[i][1] = st.nextToken();				// 방향 회전(L: 왼쪽, D: 오른쪽)
		}
		
		int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };	// → ↓ ← ↑ 오른쪽일 경우 +1, 왼쪽일 경우 -1
		int index = 0;	// 방향 인덱스
		int nr, nc;		// 뱀의 머리가 이동할 위치
		int second = 0;
		int k = 0;
		LinkedList<Integer> snakeR = new LinkedList<>(); // 뱀의 행 위치(snakeR.get(0) -> 뱀의 머리 좌표)
		LinkedList<Integer> snakeC = new LinkedList<>(); // 뱀의 열 위치(snakeC.get(0) -> 뱀의 머리 좌표)
		snakeR.add(0);
		snakeC.add(0);

		while(true) {	
			nr = snakeR.get(0) + dir[index][0];
			nc = snakeC.get(0) + dir[index][1];
			
			second++;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;	// 벽에 부딪히면
			if(board[nr][nc] == 1) break;						// 자기자신과 부딪히면
			
			if(board[nr][nc] == 2) {	// 사과를 먹으면
				snakeR.add(0, nr);	// 머리 부분 좌표 넣기
				snakeC.add(0, nc);
				board[nr][nc] = 1;	// 머리 부분 1로 만들기
			}
			else {
				board[snakeR.get(snakeR.size()-1)][snakeC.get(snakeC.size()-1)] = 0;	// 꼬리 부분 0으로 만들기
				snakeR.remove(snakeR.size()-1);		// 꼬리 부분 좌표 삭제(뱀이 이동했으므로)
				snakeC.remove(snakeC.size()-1);
				snakeR.add(0, nr);					// 머리 부분 좌표 넣기
				snakeC.add(0, nc);
				board[nr][nc] = 1;
			}
			
			if(k < d_info.length) {
				if(Integer.parseInt(d_info[k][0]) == second) {		// 해당 초에 방향 전환을 해야 한다면
					if(d_info[k][1].equals("D")) {		// 오른쪽으로 전환해야 할 경우
						if(index + 1 > 3) index = 0;	// +1
						else index++;
					}
					else {
						if(index - 1 < 0) index = 3;	// 왼쪽으로 전환해야 할 경우
						else index--;					// -1
					}
					k++;
				}
			}
		}
		
		System.out.println(second);
	}
}
