package IM_AD_모의테스트;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_AD_Shuffle_O_Matic_IndexVer {
	public static int n, card[], number[], min = 6;
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			card = new int[n];
			visited = new boolean[n];
			
			number = new int[5];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			min = 6;
			
			boolean check = true;
			for(int i=0; i<n; i++) {
				if(card[i] != i+1) {
					check = false;
					break;
				}
			}
			
			if(check) {
				min = 0;
			}
			
			check = true;
			for(int i=0; i<n; i++) {
				if(card[i] != n - i) {
					check = false;
					break;
				}
			}
			
			if(check) {
				min = Math.min(min, 0);
			}
			
			if(min == 6) dfs(0);
			
			if(min == 6) System.out.println("#" + t + " " + "-1");
			else System.out.println("#" + t + " " + min);
		}
	}
	
	public static void dfs(int depth) {
		if(depth == 5) {
			int cardCopy[] = Arrays.copyOf(card, n);
			
			for(int i=0; i<5; i++) {
				// 최솟값과 같아질 경우 그 뒤에 정렬이 된다고 하더라도 최솟값은 변동되지 않으므로 진행할 필요 X
				if(min == i + 1) return;
				
				int[] left = new int[n/2];
				int[] right = new int[n/2];
				
				for(int j=0; j<n/2; j++) {
					left[j] = cardCopy[j];
					right[j] = cardCopy[n/2 + j];
				}
				
				int leftIdx = 0;
				int rightIdx = 0;
				
				// 제일 위에 있는 카드가 왼쪽에 있는 것일 때
				if(number[i] < n/2) {
					for(int j=0; j<n; j++) {
						if(leftIdx + number[i] == n/2) {
							while(leftIdx < n/2){
								cardCopy[j++] = right[rightIdx++];
								cardCopy[j++] = left[leftIdx++];
							}
							
							for(int k=j; k<n; k++) {
								cardCopy[k] = right[rightIdx++];
							}
							break;
						}
						else {
							cardCopy[j] = left[leftIdx++];
						}
					}
				}
				// 제일 위에 있는 카드가 오른쪽에 있는 것일 때
				else {
					for(int j=0; j<n; j++) {
						if(n / 2 - rightIdx + number[i] == n) {
							while(rightIdx < n/2) {
								cardCopy[j++] = left[leftIdx++];
								cardCopy[j++] = right[rightIdx++];
							}
							
							for(int k=j; k<n; k++) {
								cardCopy[k] = left[leftIdx++];
							}
							break;
						}
						else {
							cardCopy[j] = right[rightIdx++];
						}
					}
				}
				
				boolean check = true;
				for(int j=0; j<n; j++) {
					if(cardCopy[j] != j+1) {
						check = false;
						break;
					}
				}
				
				// 오름차순 정렬일 경우
				if(check) {
					min = i + 1;
					return;
				}
				
				check = true;
				for(int j=0; j<n; j++) {
					if(cardCopy[j] != n - j) {
						check = false;
						break;
					}
				}
				
				// 내림차순 정렬일 경우
				if(check) {
					min = i + 1;
					return;
				}
			}
		}
		else {
			for(int i=1; i<n; i++) {
				number[depth] = i;
				dfs(depth + 1);
			}
		}
	}
}
