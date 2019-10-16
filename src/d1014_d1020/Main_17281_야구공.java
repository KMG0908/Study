package d1014_d1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구공 {
	public static int n = 8, numbers[] = {1, 2, 3, 4, 5, 6, 7, 8};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inning = Integer.parseInt(br.readLine());
		int[][] result = new int[inning][9];
		
		for(int i=0; i<inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		do {
			int score = 0;
			int turn = 0;
			boolean isFour = false;
			for(int i=0; i<inning; i++) {
				int out = 0;
				int base[] = new int[3];
				while(out != 3) {
					int num;
					
					if(isFour) {
						num = 0;
					}
					else {
						num = numbers[turn++];
					}
					
					switch(result[i][num]) {
					case 0:
						out++;
						break;
					case 1:
						score += base[2];
						base[2] = base[1];
						base[1] = base[0];
						base[0] = 1;
						break;
					case 2:
						score += base[2] + base[1];
						base[2] = base[0];
						base[1] = 1;
						base[0] = 0;
						break;
					case 3:
						score += base[2] + base[1] + base[0];
						base[2] = 1;
						base[1] = base[0] = 0;
						break;
					case 4:
						score += base[2] + base[1] + base[0] + 1;
						base[2] = base[1] = base[0] = 0;
						break;
					}
					
					if(isFour) {
						isFour = false;
					}
					else {
						if(turn == 3) isFour = true;
						else if(turn == 8) turn = 0;
					}
				}
			}
			max = Math.max(max, score);
		} while(nextPermutation());
		
		System.out.println(max);
	}
	
	public static boolean nextPermutation() {
		// 1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i = n - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		// 찾은 위치가 0이면 이미 내림차순된 순열이므로 다음 순열은 존재하지 않음
		if(i==0) return false;
		
		// 2. i-1 위치: 교환이 필요한 위치
		//    i-1 위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = n - 1;
		while(numbers[i-1] >= numbers[j]) j--;
		
		// 3. i-1 위치값과 j 위치값 교환
		swap(i-1, j);
		
		// 4. i 위치부터 끝까지의 순열을 오름차순으로 재조정
		j = n - 1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
