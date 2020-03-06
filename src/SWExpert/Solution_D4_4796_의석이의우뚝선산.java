package SWExpert;

import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산 {
	public static int n, mountain[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			n = sc.nextInt();
			
			mountain = new int[n];
			
			for(int i=0; i<n; i++){
				mountain[i] = sc.nextInt();
			}
			
			sb.append("#" + t + " " + solved() + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int solved(){
		int ans = 0;
		
		int up = 0, down = 0;
		
		int prev = mountain[0];
		int next = mountain[1];
		
		boolean flag = true;	// true: 커져야 하는 경우, false: 작아져야 하는 경우
		
		if(prev > next) flag = false;
		else up++;
		prev = next;
		
		for(int i=2; i<n; i++){
			next = mountain[i];
			
			if(flag){
				if(prev < next){
					up++;
				}
				else{
					flag = false;
					down++;
				}
			}
			else{
				if(prev > next){
					down++;
				}
				else {
					ans += (up * down); // 커지는 개수 * 작아지는 개수 => 해당 구간의 조합을 구할 수 있음
					flag = true;
					up = 1;
					down = 0;
				}
			}
			
			prev = next;
		}
		
		if(up != 0 && down != 0){
			ans += (up * down);	
		}
		
		return ans;
	}
}
