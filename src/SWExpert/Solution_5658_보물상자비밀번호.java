package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			String str = br.readLine();
			ArrayList<String> list = new ArrayList<>();
			
			int rotate = n / 4;
			
			for(int i=0; i<n/4; i++) {
				str = str.charAt(n-1) + str.substring(0, n-1);

				for(int j=0; j<=n - rotate; j+=rotate) {
					String sub = str.substring(j, j + rotate);
					if(!list.contains(sub)) list.add(sub);
				}
			}
			
			Collections.sort(list, new Comparator<String>() {
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			});
			
			System.out.println("#" + t + " " + Integer.parseInt(list.get(k - 1), 16));
		}
	}
}
