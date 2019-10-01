package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	public static int n, m, city[][];
	public static ArrayList<int[]> chicken = new ArrayList<>();
	public static ArrayList<int[]> select = new ArrayList<>();
	public static ArrayList<int[]> house = new ArrayList<>();
	public static boolean visited[];
	public static int res = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		city = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) house.add(new int[] {i, j});
				else if(city[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		
		visited = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == m) {
			int sum = 0;
			
			for(int i=0; i<house.size(); i++) {
				int[] h = house.get(i);
				int min = -1;
				for(int j=0; j<select.size(); j++) {
					if(min == -1) min = Math.abs(select.get(j)[0] - h[0]) + Math.abs(select.get(j)[1] - h[1]);
					else min = Math.min(min, Math.abs(select.get(j)[0] - h[0]) + Math.abs(select.get(j)[1] - h[1]));
				}
				sum += min;
			}
			
			if(res == -1) res = sum;
			else res = Math.min(res, sum);
		}
		else {
			for(int i=start; i<chicken.size(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					select.add(chicken.get(i));
					dfs(i + 1, depth + 1);
					visited[i] = false;
					select.remove(select.indexOf(chicken.get(i)));
				}
			}
		}
	}
}
