package programmers;

public class L1_체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		int answer = 0;
		
		int[] arr = new int[n];
		
		for(int i=0; i<lost.length; i++) {
			arr[lost[i]-1] -= 1;
		}
		
		for(int i=0; i<reserve.length; i++) {
			arr[reserve[i]-1] += 1;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i == 0) {
				if(arr[i] == -1) {
					if(arr[i+1] == 1) {
						arr[i] += 1;
						arr[i+1] -= 1;
					}
				}
			}
			else if(i == arr.length - 1) {
				if(arr[i] == -1) {
					if(arr[i-1] == 1) {
						arr[i] += 1;
						arr[i-1] -= 1;
					}
				}
			}
			else {
				if(arr[i] == -1) {
					if(arr[i+1] == 1) {
						arr[i] += 1;
						arr[i+1] -= 1;
					}
					else if(arr[i-1] == 1) {
						arr[i] += 1;
						arr[i-1] -= 1;
					}
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 0) answer++;
		}
		
		System.out.println(answer);
	}
}
