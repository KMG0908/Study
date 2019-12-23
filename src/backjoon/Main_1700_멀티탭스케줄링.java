package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1700_멀티탭스케줄링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i=0; i<k; i++) {
			map.put(i + 1, new ArrayList<>());
		}
		
		int[] order = new int[k];		// 사용해야 하는 물건 순서
		int[] used = new int[k + 1];		// 해당 물건을 사용한 횟수
		int[] total = new int[k + 1];	// 해당 물건을 총 사용해야 하는 횟수
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<k; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			map.get(order[i]).add(i);
			total[order[i]]++;
		}
		
		HashSet<Integer> using = new HashSet<>();
		
		int ans = 0;
		
		for(int i=0; i<k; i++) {
			if(using.size() < n) using.add(order[i]);
			else {
				if(!using.contains(order[i])) {
					int lastIdx = 0;
					int removeKey = 0;
					
					for(int key : using) {
						if(used[key] < total[key]) {	// 해당 물건을 나중에 사용해야 한다면
							int nextIdx = map.get(key).get(used[key]);	// 해당 물건이 다음에 사용되는 때
							if(nextIdx > lastIdx) {
								lastIdx = nextIdx;
								removeKey = key;
							}
						}
						else {							// 해당 물건은 더 이상 사용할 수 없으므로 제거해도 ok
							removeKey = key;
							break;
						}
					}
					
					using.remove(removeKey);
					using.add(order[i]);
					
					ans++;
				}
			}
			
			used[order[i]]++;
		}
		
		System.out.println(ans);
	}
}
