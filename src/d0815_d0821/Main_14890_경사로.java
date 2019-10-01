package d0815_d0821;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_14890_경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		boolean[][] incline = new boolean[n][n];
		for(int i=0; i<n; i++) {
			boolean flag = true;
			
			next:
			for(int j=0; j<n-1; j++) {
				if(map[i][j] < map[i][j+1]) {	// 위로 올라가야 하는 경우
					int nc = j + 1 - l;
					
					if(nc < 0) {
						flag = false;
						break;
					}
					
					if(incline[i][nc]) {		// 경사로가 이미 놓여져 있는 경우
						flag = false;
						break;
					}
					
					if(map[i][j+1] - map[i][j] != 1) { // 경사로를 놔도 올라가지 못할 경우
						flag = false;
						break;
					}
					else {
						if(map[i][j+1] - map[i][nc] != 1) {
							flag = false;
							break;
						}
						
						for(int k=nc; k<j; k++) {	// 경사로 놓은 곳
							incline[i][k] = true;
						}
					}
				}
				else if(map[i][j] > map[i][j+1]) {	// 아래로 내려가야 하는 경우
					int nc = j + l;
					
					if(nc >= n) {
						flag = false; 
						break;
					}
					
					if(map[i][j] - map[i][j + 1] != 1) { // 경사로를 놔도 내려가지 못할 경우
						flag = false;
						break;
					}
					else {
						for(int k=j+1; k<nc; k++) {
							if(map[i][k] != map[i][k+1]) {
								flag = false;
								break next;
							}
						}
						
						if(nc + 1 < n && map[i][nc+1] - map[i][nc] == 1) {	// 경사로를 통해 내려왔는데 곧바로 올라가야 하는 경우 => 경사로를 놓을 수 없음
							flag = false;
							break;
						}
						
						for(int k=j+1; k<=nc; k++) {	// 경사로 놓은 곳
							incline[i][k] = true;
						}
						
						j = nc - 1;
					}
				}
			}
			
			if(flag) {
				/*System.out.println(Arrays.toString(map[i]));*/
				cnt++;
			}
		}
		
		incline = new boolean[n][n];
		for(int j=0; j<n; j++) {
			boolean flag = true;
			
			next:
			for(int i=0; i<n-1; i++) {
				if(map[i][j] < map[i+1][j]) {	// 위로 올라가야 하는 경우
					int nr = i - l + 1;
					
					if(nr < 0) {
						flag = false;
						break;
					}
					
					if(incline[nr][j]) {		// 경사로가 이미 놓여져 있는 경우
						flag = false;
						break;
					}
					
					if(map[i+1][j] - map[i][j] != 1) { // 경사로를 놔도 올라가지 못할 경우
						flag = false;
						break;
					}
					else {
						if(map[i+1][j] - map[nr][j] != 1) {
							flag = false;
							break;
						}
						
						for(int k=nr; k<i; k++) {	// 경사로 놓은 곳
							incline[k][j] = true;
						}
					}
				}
				else if(map[i][j] > map[i+1][j]) {	// 아래로 내려가야 하는 경우
					int nr = i + l;
					
					if(nr >= n) {
						flag = false; 
						break;
					}
					
					if(map[i][j] - map[i+1][j] != 1) { // 경사로를 놔도 내려가지 못할 경우
						flag = false;
						break;
					}
					else {
						for(int k=i+1; k<nr; k++) {
							if(map[k][j] != map[k+1][j]) {
								flag = false;
								break next;
							}
						}
						
						if(nr + 1 < n && map[nr+1][j] - map[nr][j] == 1) {	// 경사로를 통해 내려왔는데 곧바로 올라가야 하는 경우 => 경사로를 놓을 수 없음
							flag = false;
							break;
						}
						
						for(int k=i+1; k<=nr; k++) {	// 경사로 놓은 곳
							incline[k][j] = true;
						}
						
						i = nr - 1;
					}
				}
			}
			
			if(flag) {
				/*for(int i=0; i<n; i++)
					System.out.print(map[i][j] + " ");
				System.out.println();*/
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
