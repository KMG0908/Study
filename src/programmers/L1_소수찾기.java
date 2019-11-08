package programmers;

public class L1_소수찾기 {
	public static void main(String[] args) {
		int n = 10;
		int answer = 0;

		/*int div = 2;
		while(div <= n) {
			boolean flag = true;
			
			for(int i=2; i<div; i++) {
				if(div % i == 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
			div++;
		}*/
		
		int[] arr = new int[n];
		
		for(int i=2; i<=n; i++) {
			arr[i-1] = i;
		}
		
		for (int i= 2; i<=n; i++) { 
	        if (arr[i-1] == 0) continue;

	        for (int j=i+i; j<=n; j += i) {
	            arr[j-1] = 0;
	        }

	    }
		
		for (int i=2; i<=n; i++) {
			if (arr[i-1] != 0) answer++;
	    }

		
		System.out.println(answer);
	}
}
