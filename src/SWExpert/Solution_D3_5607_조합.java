package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_조합 {
	public static final int mod = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		long[] factorial = new long[1000001];
		long[] inverse = new long[1000001];
		
		factorial[1] = 1;
		
		for(int i=2; i<1000001; i++) {
			factorial[i] = factorial[i-1] * i % mod;
		}
		
		inverse[1000000] = pow(factorial[1000000], mod - 2) % mod;
		
		for(int i=999999; i>0; i--) {
			inverse[i] = inverse[i + 1] * (i + 1) % mod; 
		}
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			// nCr = n! / (r! * (n-r)!)
			long result = factorial[n] * inverse[r] % mod * inverse[n - r] % mod;
			System.out.println("#" + t + " " + result);
		}
	}
	
	// 참고: https://mygumi.tistory.com/319
	public static long pow(long a, int p) {
		if(p == 1) return a;
		
		long n = pow(a, p / 2);
		
		n = n * n % mod;
		
		if(p % 2 == 1) n = n * a % mod;
		
		return n;
	}
}
