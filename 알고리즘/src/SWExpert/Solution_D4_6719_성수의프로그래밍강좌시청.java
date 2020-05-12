package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] m = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(m);
			
			double abillity = 0;
			for(int i=n-k; i<n; i++) {
				abillity = (abillity + m[i]) / 2.0;
			}
			
			System.out.println("#" + t + " " + String.format("%.6f", abillity));
		}
	}
}
