package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	public static int n, m, map[][], virusLoc[][], virus = 0, loc[], res = -1;
	public static boolean visited[][], visitedDfs[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(2 * j) - '0';
				if(map[i][j] == 2) virus++;
			}
		}
		
		virusLoc = new int[virus][2];			// 바이러스 위치
		loc = new int[m];						// 활성화 할 바이러스 인덱스 => 이것 가지고 바이러스 위치 구함
		visitedDfs = new boolean[virus];
		int idx = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 2) virusLoc[idx++] = new int[] {i, j};
			}
		}
		
		dfs(0, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == m) {
			visited = new boolean[n][n];
			bfs();
		}
		else {
			for(int i=start; i<virus; i++) {
				if(!visitedDfs[i]) {
					visitedDfs[i] = true;
					loc[depth] = i;
					dfs(i, depth + 1);
					visitedDfs[i] = false;
				}
			}
		}
	}
	
	public static void bfs() {
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0; i<m; i++) {
			queue.offer(new int[] {virusLoc[loc[i]][0], virusLoc[loc[i]][1], 0});
			visited[virusLoc[loc[i]][0]][virusLoc[loc[i]][1]] = true;
		}
		
		int sec = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		if(cnt == 0) {
			res = 0;
			return;
		}
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] != 1 && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc, info[2] + 1});
					visited[nr][nc] = true;
					
					if(map[nr][nc] == 0) {
						cnt--;
					}
				}
			}
			
			sec = info[2] + 1;
			// 더 퍼트려야 하는 곳이 없다면 break
			if(cnt == 0) break;
		}
		
		if(cnt != 0) return;
		
		if(res == -1) res = sec;
		else res = Math.min(res, sec);
	}
}
