package d0829_d0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	public static int width, height, board[][];
	public static ArrayList<int[]> line = new ArrayList<>();		// 가로선을 놓을 수 있는 위치
	public static ArrayList<int[]> select = new ArrayList<>();		// 가로선을 놓은 위치
	public static boolean[] visited;
	public static int res = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		width = 2 * n - 1;
		height = 2 * h + 1;
		
		board = new int[height][width];
		
		// 사다리 놓기
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j+=2) {
				board[i][j] = 1;
			}
		}
		
		// 가로선 놓기
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[2 * a - 1][2 * b - 1] = 1;
		}
		
		for(int i=1; i<height; i+=2) {
			for(int j=1; j<width; j+=2) {
				if(board[i][j] == 0) line.add(new int[] {i, j});
			}
		}
		
		visited = new boolean[line.size()];

		dfs(0, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 3) {
			for(int i=0; i<select.size(); i++) {
				board[select.get(i)[0]][select.get(i)[1]] = 1;
			}
			
			check();
			if(res == 0) {
				System.out.println(res);
				System.exit(0);
			}
			
			for(int i=0; i<select.size(); i++) {
				board[select.get(i)[0]][select.get(i)[1]] = 0;
			}
			
			return;
		}
		else if(depth <= 2) {
			for(int i=0; i<select.size(); i++) {
				board[select.get(i)[0]][select.get(i)[1]] = 1;
			}
			
			check();
			if(res == 0) {
				System.out.println(res);
				System.exit(0);
			}
			
			for(int i=0; i<select.size(); i++) {
				board[select.get(i)[0]][select.get(i)[1]] = 0;
			}
		}
		
		for(int i=start; i<line.size(); i++) {
			if(!visited[i]) {
				int[] info = line.get(i);
				boolean flag = true;	// 가로선을 놓을 수 있는가 
				
				for(int j=0; j<select.size(); j++) {
					int[] info_ = select.get(j);
					if(info_[0] == info[0] && Math.abs(info_[1] - info[1]) == 2) {
						flag = false;
						break;
					}
				}
				
				if(!flag) continue;
				
				visited[i] = true;
				select.add(line.get(i));
				dfs(i + 1, depth + 1);
				visited[i] = false;
				select.remove(select.indexOf(line.get(i)));
			}
		}
	}
	
	public static void check() {
		int dir[][] = { {-1, -1}, {-1, 1} };
		
		for(int j=0; j<width; j+=2) {
			int r = height - 1;
			int c = j;
			
			while(true) {
				int nr, nc;
				boolean flag = false;	// 가로선을 타고 움직였는가
				
				for(int i=0; i<2; i++) {
					nr = r + dir[i][0];
					nc = c + dir[i][1];
					
					if(nr >= 0 && nr < height && nc >= 0 && nc < width && board[nr][nc] == 1) {
						// 가로선을 타고 그 옆의 사다리로 이동
						r = nr;
						c = nc + dir[i][1];
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					// 위로 한 칸 이동
					nr = r - 1;
					
					if(nr >= 0 && nr < height) {
						r = nr;
					}
					// 움직이지 못할 경우는 끝까지 온 것이므로 break
					else break;
				}
			}
				
			if(j != c) return;
		}
		
		if(res == -1) res = select.size();
		else res = Math.min(res, select.size());
	}
}
