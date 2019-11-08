package jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1733_오목 {
	public static int board[][];
	public static boolean visited[][];
	public static int answer[] = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[19][19];
		
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<4; k++) {
			visited = new boolean[19][19];
			
			for(int i=0; i<19; i++) {
				for(int j=0; j<19; j++) {
					if(board[i][j] != 0 && !visited[i][j]) bfs(k, i, j);
				}
			}
		}
		
		System.out.println(answer[0]);
		if(answer[0] != 0) {
			System.out.println(answer[1] + " " + answer[2]);
		}
	}
	
	public static void bfs(int d, int x, int y) {
		int dir[][] = {{1, -1}, {1, 1}, {0, 1}, {1, 0}};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int count = 1;
		
		int[] last = new int[2];
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr = info[0] + dir[d][0];
			int nc = info[1] + dir[d][1];
			
			if(nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && !visited[nr][nc] && board[nr][nc] == board[x][y]) {
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				count++;
				last[0] = nr;
				last[1] = nc;
			}
		}
		
		if(count == 5) {
			answer[0] = board[x][y];
			if(last[1] < y) {
				answer[1] = last[0] + 1;
				answer[2] = last[1] + 1;
			}
			else {
				answer[1] = x + 1;
				answer[2] = y + 1;
			}
		}
	}
}
