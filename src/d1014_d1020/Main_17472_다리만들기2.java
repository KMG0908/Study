package d1014_d1020;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	private static int parents[];

	static void make() {
		Arrays.fill(parents, -1);
	}
	
	static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	public static int h, w, map[][], island, bridge[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		island = 0;
		visited = new boolean[h][w];
		
		// 각 섬에 번호 붙이기
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i, j, ++island);
				}
			}
		}
		
		bridge = new int[island + 1][island + 1];
		visited = new boolean[h][w];
		
		// 놓을 수 있는 다리 구하기
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(kruskal());
	}
	
	public static void bfs(int x, int y, int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		map[x][y] = num;
		
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					map[nr][nc] = num;
				}
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc]) {
					// 해당 좌표에 해당 섬이 위치하고 있을 때 큐에 넣기
					if(map[nr][nc] == map[info[0]][info[1]]) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
					else {
						int a = info[0];
						int b = info[1];
						
						while(true) {
							nr += dir[i][0];
							nc += dir[i][1];
							
							if(nr < 0 || nr >= h || nc < 0 || nc >= w) break;
							// 위에서 큐에 넣어서 처리할 것이므로 해당 턴에서는 break
							if(map[nr][nc] == map[info[0]][info[1]]) break;
							
							if(map[nr][nc] != 0) {
								int len = Math.abs(nr - a) + Math.abs(nc - b) - 1;
								// 길이가 2 이상일 경우에
								if(len > 1) {
									// 이미 존재하는 다리가 있다면 길이가 더 짧은 다리로
									if(bridge[map[a][b]][map[nr][nc]] != 0) {
										bridge[map[a][b]][map[nr][nc]] = Math.min(bridge[map[a][b]][map[nr][nc]], len);
										bridge[map[nr][nc]][map[a][b]] = Math.min(bridge[map[a][b]][map[nr][nc]], len);
									}
									else {
										bridge[map[a][b]][map[nr][nc]] = len;
										bridge[map[nr][nc]][map[a][b]] = len;
									}
								}
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public static int kruskal() {
		parents = new int[island + 1];
		make();
		
		int e = 0;
		
		for(int i=1; i<=island; i++) {
			for(int j=i+1; j<=island; j++) {
				if(bridge[i][j] != 0) e++;
			}
		}
		
		int[][] value = new int[e][3];
		
		int k = 0;
		for(int i=1; i<=island; i++) {
			for(int j=i+1; j<=island; j++) {
				if(bridge[i][j] != 0) {
					value[k][0] = bridge[i][j];
					value[k][1] = i;
					value[k++][2] = j;
				}
			}
		}
		
		Arrays.sort(value, new Comparator<int[]>() {
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		
		int sum = 0;
		int cnt = 0;
		
		for(int i=0; i<e; i++) {
			if(union(value[i][1], value[i][2])) {
				sum += value[i][0];
				cnt++;
			}
			
			if(cnt == island - 1) break;
		}
		
		if(cnt == island - 1) return sum;
		else return  - 1;
	}
}
