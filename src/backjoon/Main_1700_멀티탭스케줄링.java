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
		int[] idx = new int[k + 1];		// 해당 물건을 사용한 횟수
		int[] total = new int[k + 1];	// 해당 물건을 총 사용해야 하는 횟수
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<k; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			map.get(order[i]).add(i);
			total[order[i]]++;
		}
		
		HashSet<Integer> use = new HashSet<>();
		
		int ans = 0;
		
		for(int i=0; i<k; i++) {
			if(use.size() < n) use.add(order[i]);
			else {
				if(!use.contains(order[i])) {
					int max = 0;
					int removeKey = 0;
					
					for(int key : use) {
						if(idx[key] < total[key]) {
							int nextIdx = map.get(key).get(idx[key]);
							if(nextIdx > max) {
								max = nextIdx;
								removeKey = key;
							}
						}
						else {
							removeKey = key;
							break;
						}
					}
					
					System.out.println("removeKey: " + removeKey);
					use.remove(removeKey);
					use.add(order[i]);
					
					ans++;
				}
			}
			
			idx[order[i]]++;
		}
		
		System.out.println(ans);
	}
}
