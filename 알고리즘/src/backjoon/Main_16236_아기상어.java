package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	public static int n, map[][], shark[], res = 0, cnt = 0;
	public static boolean visited[][], possible = true;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new int[] {i, j, 2, 2};	// 상어 좌표, 상어 크기, 먹어야 하는 물고기 수
					map[i][j] = 0;
				}
			}
		}
		
		while(possible) {
			visited = new boolean[n][n];
			bfs(shark[0], shark[1], 0);
		}
		
		System.out.println(res);
	}
	
	public static void bfs(int x, int y, int cnt) {
		int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, cnt});
		visited[x][y] = true;
		
		int distance = 0;
		boolean flag = false;	// 먹을 수 있는 물고기가 있는가
		
		ArrayList<int[]> fish = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			if(flag) {
				if(info[2] > distance) break;
			}
			
			int nr, nc;
			
			for(int i=0; i<4; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] <= shark[2]) {
					if(map[nr][nc] > 0 && map[nr][nc] < shark[2]) {	// 해당 칸에 있는 물고기를 먹을 수 있으면
						flag = true;
						/* if(info[2] > distance) 
						 * => info[2]와 distance가 같은 경우에도 아래가 진행되므로 distance가 바뀌게 됨
						 * => distance가 초기값일 경우에만 distance를 바꿔줘야 함 */
						if(distance == 0) distance = info[2] + 1;
						/* 마찬가지로 info[2]와 distance가 같은 경우에 아래가 진행되므로
						 * 현재 상어와 물고기 사이의 거리가 distance보다 클 경우에도 fish에 넣어주게 되면
						 * fish를 오름차순으로 정렬할 때 거리가 더 먼 것을 먼저 먹으러 가게 되는 경우가 생김 */
						if(distance == info[2] + 1) fish.add(new int[] {nr, nc});
					}
					queue.offer(new int[] {nr, nc, info[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
		
		if(fish.size() == 0) {		// 먹을 수 있는 물고기가 없는 경우
			possible = false;
			return;
		}
		else if(fish.size() > 1) {	// 먹을 수 있는 물고기가 2마리 이상인 경우
			// 오름차순 정렬(가장 위, 왼쪽에 있는 것이 가장 작으므로)
			Collections.sort(fish, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
				}
			});
		}
		
		int[] info = fish.get(0);
		
		map[info[0]][info[1]] = 0;
		shark[0] = info[0];
		shark[1] = info[1];
		shark[3]--;
		if(shark[3] == 0) {
			shark[2]++;
			shark[3] = shark[2];
		}
		res += distance;
		
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(shark));
		System.out.println();*/
	}
}
