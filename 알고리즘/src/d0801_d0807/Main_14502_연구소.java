package d0801_d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int n, m;
	static int[][] map;
	static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;				// 벽 세우기
					wall(1);
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void copy(int[][] map, int[][] copyMap) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) copyMap[i][j] = map[i][j];
		}
	}
	
	public static void wall(int cnt) {
		if(cnt == 3) {
			spread();				// 벽 3개 다 세우면 바이러스 퍼트리기
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void spread() {
		int[][] spreadMap = new int[n][m];
		copy(map, spreadMap);
		
		ArrayList<Integer> virusX = new ArrayList<>();
		ArrayList<Integer> virusY = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(spreadMap[i][j] == 2) {
					virusX.add(i);
					virusY.add(j);
				}
			}
		}
		
		while(virusX.size() > 0) {
			int r = virusX.get(0);
			int c = virusY.get(0);
			
			virusX.remove(0);
			virusY.remove(0);
			
			for(int i=0; i<4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if(spreadMap[nr][nc] == 0) {
						spreadMap[nr][nc] = 2;
						virusX.add(nr);
						virusY.add(nc);
					}
				}
			}
		}
		
		checkArea(spreadMap);
	}

	private static void checkArea(int[][] spreadMap) {
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(spreadMap[i][j] == 0) cnt++;
			}
		}
		
		if(cnt > max) max = cnt;
	}
}
