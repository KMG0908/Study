package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_1907_모래성쌓기 {
	public static int h, w;
	public static int[][] map, sand, dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			sand = new int[h][w];
			
			for(int i=0; i<h; i++){
				String temp = br.readLine();
				for(int j=0; j<w; j++){
					char ch = temp.charAt(j);
					if(ch >= '0' && ch <= '9') map[i][j] = ch - '0';
					else map[i][j] = 0;
				}
			}
			
			sb.append("#" + t + " " + bfs() + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int bfs(){
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=1; i<h-1; i++){
			for(int j=1; j<w-1; j++){
				int nr, nc;
				for(int k=0; k<8; k++){
					nr = i + dir[k][0];
					nc = j + dir[k][1];
					if(map[nr][nc] == 0) sand[i][j]++;
				}
				
				if(map[i][j] != 0 && map[i][j] <= sand[i][j]){
					queue.offer(new int[]{i, j});
				}
			}
		}
		
		int cnt = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int[] info = queue.poll();
				
				int nr, nc;
				for(int j=0; j<8; j++){
					nr = info[0] + dir[j][0];
					nc = info[1] + dir[j][1];
					
					// dmg[nr][nc]는 map[info[0]][info[1]]가 무너짐에 따라 하나 증가
					if(map[nr][nc] > sand[nr][nc]) sand[nr][nc]++;
					// 모래이거나 모래로 변할 것은 제외
					else continue;
					
					if(map[nr][nc] <= sand[nr][nc]) queue.offer(new int[]{nr, nc});
				}
			}
			
			cnt++;
		}
		
		return cnt;
	}
}
