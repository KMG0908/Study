package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6109_추억의2048게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			
			String oper = st.nextToken();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			switch(oper) {
			case "up":
				for(int i=0; i<n-1; i++) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == 0) {						// 위로 옮기기(사이에 0이 존재하지 않게)
							for(int k=i; k<n-1; k++) {
								int c = k;
								
								while(true) {
									if(c+1 >= n) break;
									
									if(map[++c][j] != 0) {
										map[k][j] = map[c][j];
										map[c][j] = 0;
										break;
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<n-1; i++) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == map[i+1][j]) {		// 아래의 것과 같으면 합치고 나머지 한칸씩 끌어오기
							map[i][j] *= 2;
							map[i+1][j] = 0;
							
							for(int k=i+1; k<n-1; k++) {
								map[k][j] = map[k+1][j];
								map[k+1][j] = 0;
							}
						}
					}
				}
				break;
			case "down":
				for(int i=n-1; i>0; i--) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == 0) {
							for(int k=i; k>0; k--) {
								int c = k;
								
								while(true) {
									if(c-1 < 0) break;
									
									if(map[--c][j] != 0) {
										map[k][j] = map[c][j];
										map[c][j] = 0;
										break;
									}
								}
							}
						}
					}
				}
				
				for(int i=n-1; i>0; i--) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == map[i-1][j]) {
							map[i][j] *= 2;
							map[i-1][j] = 0;
							
							for(int k=i-1; k>0; k--) {
								map[k][j] = map[k-1][j];
								map[k-1][j] = 0;
							}
						}
					}	
				}
				break;
			case "left":
				for(int i=0; i<n; i++) {
					for(int j=0; j<n-1; j++) {
						if(map[i][j] == 0) {
							for(int k=j; k<n-1; k++) {
								int c = k;
								
								while(true) {
									if(c+1 >= n) break;
									
									if(map[i][++c] != 0) {
										map[i][k] = map[i][c];
										map[i][c] = 0;
										break;
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					for(int j=0; j<n-1; j++) {
						if(map[i][j] == map[i][j+1]) {
							map[i][j] *= 2;
							map[i][j+1] = 0;
							
							for(int k=j+1; k<n-1; k++) {
								map[i][k] = map[i][k+1];
								map[i][k+1] = 0;
							}
						}
					}
				}
				break;
			case "right":
				for(int i=0; i<n; i++) {
					for(int j=n-1; j>0; j--) {
						if(map[i][j] == 0) {
							for(int k=j; k>0; k--) {
								int c = k;
								
								while(true) {
									if(c-1 < 0) break;
									
									if(map[i][--c] != 0) {
										map[i][k] = map[i][c];
										map[i][c] = 0;
										break;
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					for(int j=n-1; j>0; j--) {
						if(map[i][j] == map[i][j-1]) {
							map[i][j] *= 2;
							map[i][j-1] = 0;
							
							for(int k=j-1; k>0; k--) {
								map[i][k] = map[i][k-1];
								map[i][k-1] = 0;
							}
						}
					}
				}
				break;
			}
			
			sb.append("#" + t + "\n");
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
