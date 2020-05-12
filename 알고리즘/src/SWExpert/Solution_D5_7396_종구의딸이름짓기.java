package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기 {
	public static int n, m, dir[][] = {{0, 1}, {1, 0}};
	public static char map[][];
	public static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			visited = new boolean[n][m];
			
			for(int i=0; i<n; i++){
				map[i] = br.readLine().toCharArray();
			}
			
			sb.append("#" + t + " " + solved() + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static String solved(){
		char ans[] = new char[n + m - 1];
		Arrays.fill(ans, 'z');

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visited[0][0] = true;
		
		int idx = 0;
		ans[0] = map[0][0];
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				Point point = queue.poll();
				
				// 큐에 들어있는 쓸데없는 것은 뺌
				// 깊이 idx만큼 들어간 것 중에 최소값(ans[idx])에 해당되는 것만 확인
				if(ans[idx] != map[point.x][point.y]) continue;
				
				int nr, nc;
				for(int j=0; j<2; j++){
					nr = point.x + dir[j][0];
					nc = point.y + dir[j][1];
					
					if(nr < n && nc < m && !visited[nr][nc]){
						// 깊이 idx+1만큼 들어간 것 중에 최소값으로 ans[idx+1]을 채움
						if(ans[idx + 1] > map[nr][nc]) ans[idx + 1] = map[nr][nc];
						
						visited[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}
			
			idx++;
		}
	
		return new String(ans);
	}
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
