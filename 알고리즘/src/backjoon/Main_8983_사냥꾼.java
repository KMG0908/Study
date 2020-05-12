package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_8983_사냥꾼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> hunter = new TreeSet<>();;
		int[][] animals = new int[n][2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			hunter.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());	// 왼쪽에서 얼마나 떨어졌는지(열)
			int y = Integer.parseInt(st.nextToken());	// 아래에서 얼마나 떨어졌는지(행)
			
			int start = x - (l - y);
			int end = x + (l - y);
			
			animals[i] = new int[] {start, end};
		}
		
		Arrays.sort(animals, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0]? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		
		Iterator<Integer> iter = hunter.iterator();
		
		int x = iter.next();
		for(int i=0; i<n; i++) {
			int start = animals[i][0];
			int end = animals[i][1];
			
			// end가 start 보다 더 큰 경우는 높이가 사정거리를 벗어났다는 의미
			if(end - start < 0) continue;
			// 사대가 동물을 잡는 것이 가능한 끝점을 넘어가면 다음 동물 위치로 넘어감
			if(x > end) continue;
			// 사대가 동물을 잡는 것이 가능한 시작점에 도달하지 못했고, 다음 사대의 위치가 존재하지 않는다면 이후의 동물은 모두 잡을 수 없음
			if(x < start && !iter.hasNext()) break;
			
			// 사대가 범위 안에 있을 경우
			if(x >= start && x <= end) {
				count++;
			}
			else {
				x = iter.next();
				i--;
			}
		}
		
		System.out.println(count);
	}
}
