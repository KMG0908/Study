package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	public static int n, map[][];
	public static int dir[][] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static Location initial[], goal[];
	public static boolean visited[][][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		// 통나무가 가로 방향일 때(0)와 세로 방향일 때(1)의 방문 처리를 위한 배열
		visited = new boolean[2][n][n];
		initial = new Location[3];
		goal = new Location[3];
		
		int initialIdx = 0;
		int goalIdx = 0;
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++) {
				switch(input.charAt(j)) {
				case 'B':
					initial[initialIdx] = new Location(i, j);
					initialIdx++;
					map[i][j] = 0;
					break;
				case 'E':
					goal[goalIdx] = new Location(i, j);
					goalIdx++;
					map[i][j] = 0;
					break;
				case '0':
					map[i][j] = 0;
					break;
				case '1':
					map[i][j] = 1;
					break;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Location[]> queue = new LinkedList<>();
		queue.offer(initial);
		Queue<Integer> direction = new LinkedList<>();
		// 통나무가 가로 방향으로 있을 때
		if(initial[0].x == initial[1].x && initial[1].x == initial[2].x) {
			for(int i=0; i<3; i++) {
				visited[0][initial[i].x][initial[i].y] = true;
			}
			direction.offer(0);
		}
		// 통나무가 세로 방향으로 있을 때
		else if(initial[0].y == initial[1].y && initial[1].y == initial[2].y) {
			for(int i=0; i<3; i++) {
				visited[1][initial[i].x][initial[i].y] = true;
			}
			direction.offer(1);
		}
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s=0; s<size; s++) {
				Location[] location = queue.poll();
				int d = direction.poll();
				
				if(isGoal(location)) return cnt;
				
				next:
				for(int i=0; i<4; i++) {
					int nr, nc;
					boolean flag = false;	// 방문하지 않은 지점이 하나라도 있는가?
					Location[] tmp = new Location[3];
						
					for(int j=0; j<3; j++) {
						nr = location[j].x + dir[i][0];
						nc = location[j].y + dir[i][1];
						if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue next;
						if(map[nr][nc] == 1) continue next;
						if(!visited[d][nr][nc]) flag = true;
						tmp[j] = new Location(nr, nc);
					}
						
					if(flag) {
						queue.offer(tmp);
						for(int k=0; k<3; k++) {
							visited[d][tmp[k].x][tmp[k].y] = true;
						}
						direction.offer(d);
					}
				}
				
				if(location[0].x == location[1].x && location[1].x == location[2].x) {
					int centerX = location[0].x;
					int centerY = (location[0].y + location[1].y + location[2].y) / 3;
					if(available(location[0].x, (location[0].y + location[1].y + location[2].y) / 3, 0)) {
						Location[] tmp = new Location[3];
						
						tmp[0] = new Location(centerX - 1, centerY);
						tmp[1] = new Location(centerX, centerY);
						tmp[2] = new Location(centerX + 1, centerY);
						
						queue.offer(tmp);
						for(int k=0; k<3; k++) {
							visited[(d + 1) % 2][tmp[k].x][tmp[k].y] = true;
						}
						direction.offer((d + 1) % 2);
					}
				}
				else if(location[0].y == location[1].y && location[1].y == location[2].y) {
					int centerX = (location[0].x + location[1].x + location[2].x) / 3;
					int centerY = location[0].y;
					if(available((location[0].x + location[1].x + location[2].x) / 3, location[0].y, 1)) {
						Location[] tmp = new Location[3];
						
						tmp[0] = new Location(centerX, centerY - 1);
						tmp[1] = new Location(centerX, centerY);
						tmp[2] = new Location(centerX, centerY + 1);
						
						queue.offer(tmp);
						for(int k=0; k<3; k++) {
							visited[(d + 1) % 2][tmp[k].x][tmp[k].y] = true;
						}
						direction.offer((d + 1) % 2);
					}
				}
			}
			
			cnt++;
		}
		
		
		return 0;
	}
	
	public static boolean available(int x, int y, int dir){
		if(x-1 < 0 || x+1 >= n || y-1 < 0 || y+1 >= n) return false;
		
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		
		// 통나무가 가로 방향이었다면 세로 방향으로 회전해야 하므로 visited는 세로 방향일 경우를 확인해야 함
		if(dir == 0) {
			if(!visited[1][x-1][y] || !visited[1][x+1][y]) return true;
		}
		else {
			if(!visited[0][x][y-1] || !visited[0][x][y+1]) return true;
		}
		
		return false;
	}
	
	public static boolean isGoal(Location[] location) {
		int cnt = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(location[i].x == goal[j].x && location[i].y == goal[j].y) cnt++;
			}
		}
		
		if(cnt == 3) return true;
		else return false;
	}
	
	public static class Location{
		int x;
		int y;
		
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Location [x=" + x + ", y=" + y + "]";
		}
	}
}
