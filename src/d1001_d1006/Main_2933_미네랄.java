package d1001_d1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 푼 시간: 34분
 * But, 문제를 이해하지 못해 다른 사람 설명 참고하였음...
 */
public class Main_2933_미네랄 {
	public static int r, c, dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int height = r - Integer.parseInt(st.nextToken());
			visited = new boolean[r][c];
			
			// 왼쪽에서 막대를 던질 경우
			if(i % 2 == 0) {
				for(int j=0; j<c; j++) {
					if(map[height][j] == 'x') {
						map[height][j] = '.';
						
						int nr, nc;
						for(int k=0; k<4; k++) {
							nr = height + dir[k][0];
							nc = j + dir[k][1];
							
							// 클러스터가 공중에 떠 있는가?
							if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 'x' && !visited[nr][nc]) {
								bfs(nr, nc);
							}
						}
						
						break;
					}
				}
			}
			// 오른쪽에서 막대를 던질 경우
			else {
				for(int j=c-1; j>=0; j--) {
					if(map[height][j] == 'x') {
						map[height][j] = '.';
						
						int nr, nc;
						for(int k=0; k<4; k++) {
							nr = height + dir[k][0];
							nc = j + dir[k][1];
							
							if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 'x' && !visited[nr][nc]) {
								bfs(nr, nc);
							}
						}
						
						break;
					}
				}
			}
		}
		
		for(int k=0; k<r; k++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[k][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void bfs(int x, int y) {
		boolean[][] cluster = new boolean[r][c];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		cluster[x][y] = true;
		
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			int info[] = queue.poll();
			
			int nr, nc;
			for(int k=0; k<4; k++) {
				nr = info[0] + dir[k][0];
				nc = info[1] + dir[k][1];
				
				if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 'x' && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					cluster[nr][nc] = true;
					if(nr == r - 1) flag = true;
				}
			}
		}
		
		// 클러스터가 공중에 떠 있다면 떨어뜨리기
		if(!flag) fall(cluster);
	}
	
	public static void fall(boolean[][] cluster) {
		int min = Integer.MAX_VALUE;
		
		boolean visitedJ[] = new boolean[c];
		
		for(int i=r-1; i>=0; i--) {
			for(int j=0; j<c; j++) {
				// 클러스터의 각 열에서 가장 바닥과 가까이 있는 것만 확인
				if(!visitedJ[j] && cluster[i][j]) {
					int nr = i;
					int nc = j;
					int count = 0;
					
					while(true) {
						nr += 1;
						
						if(nr >= r) break;
						if(map[nr][nc] == 'x') break;
						count++;
					}
					
					// 모양을 유지하며 떨어뜨릴 수 있는 최대 칸 수
					min = Math.min(min, count);
					
					visitedJ[j] = true;
				}
			}
		}
		
		// 클러스터 떨어뜨리기
		for(int i=r-1; i>=0; i--) {
			for(int j=0; j<c; j++) {
				if(cluster[i][j]) {
					map[i][j] = '.';
					map[i + min][j] = 'x';
				}
			}
		}
	}
}
