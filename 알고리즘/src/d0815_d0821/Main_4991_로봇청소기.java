package d0815_d0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {
	public static int w, h;
	public static char[][] room;
	public static boolean visited[][], visitedDfs[];// 로봇 청소기 이동에 필요, 이동 순서를 짜는데 필요
	public static int[] combi;						// 움직이는 순서
	public static ArrayList<int[]> list;			// 로봇 좌표 + 청소해야 하는 곳 좌표
	public static int size;							// list의 사이즈
	public static int distance[][];					// 로봇의 이동 횟수
	public static boolean check = false;			// 청소해야 하는 곳에 도달할 수 있는가 없는가
	public static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			room = new char[h][w];
			visited = new boolean[h][w];
			
			list = new ArrayList<>();
			
			for(int i=0; i<h; i++) {
				String str = br.readLine();
				for(int j=0; j<w; j++) {
					room[i][j] = str.charAt(j);
					if(room[i][j] == 'o') {
						list.add(0, new int[] {i, j});
					}
					else if(room[i][j] == '*') {
						list.add(new int[] {i, j});
					}
				}
			}
			
			size = list.size();
			
			distance = new int[size][size];
			
			for(int i=0; i<size-1; i++) {
				for(int j=i+1; j<size; j++) {
					bfs(list.get(i), list.get(j), i, j);
				}
			}
			
			combi = new int[size];
			combi[0] = 0;
			visitedDfs = new boolean[size-1];	// 처음 시작은 항상 로봇 위치여야 하므로 로봇 위치는 제외
			
			check = false;		// 청소해야 하는 곳까지 도달할 수 없는 경우가 있는지 확인
			result = -1;
			dfs(0);
			
			if(!check) System.out.println(result);
			else System.out.println("-1");
		}
	}
	
	public static void bfs(int[] start, int[] end, int startIdx, int endIdx) {
		visited = new boolean[h][w];
		
		int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0], start[1], 0});
		
		int cnt = -1;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int nr, nc;
			
			if(info[0] == end[0] && info[1] == end[1]) {
				// bfs이므로 가장 처음에 도착한 것이 최소값이 됨
				cnt = info[2];
				
				break;
			}
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && room[nr][nc] != 'x') {
					queue.offer(new int[] {nr, nc, info[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
		
		// startIdx에 해당하는 위치에서 endIdx에 해당하는 위치까지 움직여야 하는 횟수(반대도 동일)
		distance[startIdx][endIdx] = cnt;
		distance[endIdx][startIdx] = cnt;
	}
	
	public static void dfs(int depth) {
		if(depth == size-1) {
			int total = 0;
			
			for(int i=0; i<size-1; i++) {
				if(distance[combi[i]][combi[i+1]] == -1) {
					check = true;
					break;
				}
				else total += distance[combi[i]][combi[i+1]];
			}
			
			if(!check) {
				if(result == -1) result = total;
				else result = Math.min(result, total);
			}
		}
		else {
			for(int i=0; i<size-1; i++) {
				if(!visitedDfs[i]) {
					visitedDfs[i] = true;
					combi[depth + 1] = i + 1;
					dfs(depth + 1);
					visitedDfs[i] = false;
				}
			}
		}
	}
}
