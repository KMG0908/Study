package d1014_d1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고: https://sophia2730.tistory.com/entry/Algorithm-%EB%B0%B1%EC%A4%8017136-%EC%83%89%EC%A2%85%EC%9D%B4-%EB%B6%99%EC%9D%B4%EA%B8%B0
public class Main_17136_색종이붙이기 {
	public static int map[][], paper[] = {0, 5, 5, 5, 5, 5}, one = 0, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) one++;
			}
		}
		
		// r = 해당 row, cnt = 사용한 색종이 수, total = 제거한 1의 수
		stick(0, 0, 0);
		
		System.out.println(min == Integer.MAX_VALUE? -1 : min);
	}
	
	public static void stick(int r, int cnt, int total) {
		if(min <= cnt) return;	// 색종이를 더 많이 사용했을 경우 종료
		if(total == one) {		// 1 부분에 색종이를 모두 붙인 경우
			min = Math.min(min, cnt);
			return;
		}
		
		for(int i=r; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j] == 1) {
					boolean flag = false;	// 큰 색종이로 덮을 수 있다면 그보다 작은 색종이로도 덮을 수 있음
					
					for(int k=5; k>=1; k--) {
						if((i + k) <= 10 && (j + k) <= 10 && paper[k] > 0) {
							if(!flag) {
								flag = check(i, j, k);	// 해당 부분이 모두 1일 경우 => 색종이로 덮을 수 있을 경우
							}
							
							if(flag) {
								setVisited(i, j, k);
								paper[k]--;
								stick(i, cnt + 1, total + k * k);
								setVisited(i, j, k);
								paper[k]++;
							}
						}
					}
					
					if(!flag) return;	// 색종이로 덮을 수 없는 경우
				}
				if(map[i][j] == 1) return;	// 덮고나서도 해당 좌표를 지우지 못하는 경우
			}
		}
	}
	
	public static boolean check(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	
	// 방문한 점은 XOR 계산 => 0이면 1로, 1이면 0으로
	public static void setVisited(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				map[i][j] ^= 1;
			}
		}
	}
}
