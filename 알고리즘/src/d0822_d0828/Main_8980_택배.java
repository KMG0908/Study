package d0822_d0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_8980_택배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		int[][] info = new int[m][3];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int amount = Integer.parseInt(st.nextToken());
			info[i][0] = end;
			info[i][1] = start;
			info[i][2] = amount;
		}
		
		// 도착 지점을 기준으로 오름차순 정렬, 같다면 내림차순 정렬(거리가 적게 차이나는 걸 먼저 실어야 더 많이 배달할 수 있음)
		Arrays.sort(info, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0]? o2[1] - o1[1]: o1[0] - o2[0];
			}
		});
		
		// 해당 마을에서 택배에 얼마나 물건이 실려져 있는지
		int[] truck = new int[n];
		int res = 0;
		
		for(int i=0; i<m; i++) {
			int start = info[i][1];
			int end = info[i][0];
			int amount = info[i][2];
			
			int get = 0;
			for(int j=start; j<end; j++) {
				get = Math.max(get, truck[j]);
			}
			
			// 트럭에 얼마나 더 채울 수 있는지
			int deliver = Math.min(amount, c - get);
			res += deliver;
			
			for(int j=start; j<end; j++) {
				truck[j] += deliver;
			}

			//System.out.println(Arrays.toString(truck));
		}
		
		System.out.println(res);
	}
}
