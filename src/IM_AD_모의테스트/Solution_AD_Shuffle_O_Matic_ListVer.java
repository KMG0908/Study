package IM_AD_모의테스트;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_AD_Shuffle_O_Matic_ListVer {
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
			
			for(int i=0; i<number.length; i++) {
				if(min == i + 1) return;
				
				ArrayList<Integer> left = new ArrayList<>();
				ArrayList<Integer> right = new ArrayList<>();
				
				for(int j=0; j<n/2; j++) {
					left.add(cardCopy[j]);
					right.add(cardCopy[n/2+j]);
				}
				
				if(number[i] == n-1) {
					for(int j=0; j<n; j++) {
						if(right.size() != 0) cardCopy[j] = right.remove(0);
						else cardCopy[j] = left.remove(0);
					}
				}
				else if(number[i] < n/2) {
					for(int j=0; j<n; j++) {
						if(number[i] == left.size()) {
							while(left.size() > 0) {
								cardCopy[j++] = right.remove(0);
								cardCopy[j++] = left.remove(0);
							}
							
							for(int k=j; k<n; k++) {
								cardCopy[k] = right.remove(0);
							}
							
							break;
						}
						else {
							cardCopy[j] = left.remove(0);
						}
					}
				}
				else {
					for(int j=0; j<n; j++) {
						if(right.size() + 1 + number[i] == n) {
							while(right.size() > 0) {
								cardCopy[j++] = left.remove(0);
								cardCopy[j++] = right.remove(0);
							}
							
							for(int k=j; k<n; k++) {
								cardCopy[k] = left.remove(0);
							}
							
							break;
						}
						else {
							cardCopy[j] = right.remove(0);
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
