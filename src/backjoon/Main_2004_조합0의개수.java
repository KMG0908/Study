package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2004_조합0의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int two = countTwo(n);
		if (r != 0) two -= countTwo(r);
		if (n != r) two -= countTwo(n - r);
		
		int five = countFive(n);
	    if (r != 0) five -= countFive(r);
	    if (n != r) five -= countFive(n - r);

		System.out.println(Math.min(two, five));
	}
	
	public static int countTwo(int n) {
		int two = 0;
		
	    for(long i=2; i<=n; i*=2) {
	    	two += n / i;
		}
	    
	    return two;
	}
	 
	
	public static int countFive(int n) {
		int five = 0;
		
	    for(long i=5; i<=n; i*=5) {
			five += n / i;
		}
	    
	    return five;
	}
}
