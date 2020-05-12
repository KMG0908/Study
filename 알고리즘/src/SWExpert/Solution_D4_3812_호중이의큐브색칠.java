package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3812_호중이의큐브색칠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			// |i - a| mod n => |i mod n - a mod n|과 동일
			a %= n;
			b %= n;
			c %= n;
			
			// 한 줄
			long[] line = new long[n];
			// 한 줄에 각 색이 나타나는 최소 횟수 => (x - a) / n
			Arrays.fill(line, (x - a) / n);
			
			// 뒤에 남는 것
			// n - 1 색깔로 끝이 났을 것이므로 0번째 색깔부터 채움
			for (int i = 0; i < (x - a) - ((x - a) / n) * n; i++) {
	            line[i]++;
			}
	 
			// 앞에 남는 것
			// (0, 0, 0)은 a 색깔로 칠해질 것이고, 그 후부터는 행이 늘어남에 따라 줄어든다(|i - a| 이므로)
			// (a, 0, 0)부터는 Arrays.fill에 의해 처리됨
	        for (int i = 1; i <= a; i++) {
	            line[i]++;
	        }
	        
	        // 한 면
	        long[] slide = new long[n];
	        Arrays.fill(slide, (long) (y - b) / n * x);
	        
	        // 뒤에 남는 것
	        // 열의 뒷 부분 -> 즉, 뒤의 행이 몇 개 남는 것
	        // 각 행에서 가능한 색깔을 다 더해야 함
	        for (int i = 0; i < (y - b) - ((y - b) / n) * n; i++) {
	        	for (int k = 0; k < n; k++) {
	        		/* 앞 열이 이렇게 나온다면  다음 열은 이런 식으로 나옴
	        		 * 0				1
	        		 * 1				2
	        		 * 2				3
	        		 * 3				4
	        		 * 4				5
	        		 * => 따라서 각 열에 따라 k + i로 계산
	        		 */
	        		slide[(k + i) % n] += line[k];
	        	}
	        }
	        
	        // 앞에 남는것
	        // 열의 앞 부분 -> 즉, 앞의 행이 몇 개 남는 것
	        for (int i = 1; i <= b; i++) { 
	            for (int k = 0; k < n; k++) {
	                slide[(k + i) % n] += line[k];
	            }
	        }
	        
	        // 큐브 전체 구하기
	        long[] res = new long[n];
	        Arrays.fill(res, (long) (z - c) / n * y * x);
	        // 뒤에 남는것
	        for (int i = 0; i < (z - c) - ((z - c) / n) * n; i++) {
	            for (int k = 0; k < n; k++) {
	                res[(k + i) % n] += slide[k];
	            }
	        }
	        
	        // 앞에 남는것
	        for (int i = 1; i <= c; i++) {
	            for (int k = 0; k < n; k++) {
	                res[(k + i) % n] += slide[k];
	            }
	        }
			
			sb.append("#" + t + " ");
			
			for(int i=0; i<n; i++) {
				sb.append(res[i] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
