package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            
            int[] arr = new int[n];
            int[] dp = new int[n];  // 증가 수열 길이
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[j] = Integer.parseInt(st.nextToken());
             
            int max = 0;
            dp[0] = 1;
 
            for(int i=1;i<n;i++) {
                dp[i] = 1;
                // 자신보다 작은 인덱스에 있는 증가 수열 길이 비교
                for(int k=0; k<i; k++) {
                    if (arr[i] >= arr[k]) {
                        dp[i] = Math.max(dp[i], dp[k] + 1);
                    }
                }
                
                max = Math.max(max, dp[i]);
            }
             
            System.out.println("#" + t + " " + max);
        }
    }
}