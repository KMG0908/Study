package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	public static int row = 3, col = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[row][col];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sec = 0;
		
		while(true) {
			if(r < row && c < col) {
				if(map[r][c] == k) break;
			}
			if(sec >= 100) {
				sec = -1;
				break;
			}
			
			if(row >= col) map = operR(map);
			else map = operC(map);
			sec++;
			
			/*for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();*/
		}
		
		System.out.println(sec);
	}
	
	public static int[][] operR(int[][] arr) {
		ArrayList<List<Map.Entry<Integer, Integer>>> list = new ArrayList<>();
		
		int c = 0;
		
		for(int i=0; i<row; i++) {
			HashMap<Integer, Integer> hash = new HashMap<>();
			for(int j=0; j<col; j++) {
				if(arr[i][j] == 0) continue;
				
				if(hash.containsKey(arr[i][j])) hash.put(arr[i][j], hash.get(arr[i][j]) + 1);
				else hash.put(arr[i][j], 1);
			}
			
			c = Math.max(c, hash.size());
			
			List<Map.Entry<Integer, Integer>> l = new LinkedList<>(hash.entrySet());
			// value를 기준으로 오름차순 정렬
			Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
	                return o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue();
				}
			});
			
			list.add(l);
		}
		
		col = c * 2;
		
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			List<Map.Entry<Integer, Integer>> tmp = list.get(i);
			int size = tmp.size();
			
			int k = 0;
			for(int j=0; j<size; j++) {
				arr[i][k++] = tmp.get(j).getKey();
				arr[i][k++] = tmp.get(j).getValue();
			}
		}
		
		return arr;
	}
	
	public static int[][] operC(int[][] arr) {
		ArrayList<List<Map.Entry<Integer, Integer>>> list = new ArrayList<>();
		
		int r = 0;
		
		for(int j=0; j<col; j++) {
			HashMap<Integer, Integer> hash = new HashMap<>();
			for(int i=0; i<row; i++) {
				if(arr[i][j] == 0) continue;
				
				if(hash.containsKey(arr[i][j])) hash.put(arr[i][j], hash.get(arr[i][j]) + 1);
				else hash.put(arr[i][j], 1);
			}
			
			r = Math.max(r, hash.size());
			
			List<Map.Entry<Integer, Integer>> l = new LinkedList<>(hash.entrySet());
			// value를 기준으로 오름차순 정렬
			Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
	                return o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue();
				}
			});
			
			list.add(l);
		}

		row = r * 2;
		
		arr = new int[row][col];
		
		for(int j=0; j<col; j++) {
			List<Map.Entry<Integer, Integer>> tmp = list.get(j);
			int size = tmp.size();
			
			int k = 0;
			for(int i=0; i<size; i++) {
				arr[k++][j] = tmp.get(i).getKey();
				arr[k++][j] = tmp.get(i).getValue();
			}
		}
		
		return arr;
	}
}
