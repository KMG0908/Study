package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	public static int n, m, numbers[], totalHouse, totalChicken, ans = Integer.MAX_VALUE;
	public static ArrayList<int[]> house, chicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) house.add(new int[] {i, j});
				else if(tmp == 2) chicken.add(new int[] {i, j});
			}
		}
		
		totalHouse = house.size();
		totalChicken = chicken.size();
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == m) {
			int sum = 0;
			
			for(int i=0; i<totalHouse; i++) {
				int min = Integer.MAX_VALUE;
				int[] h = house.get(i);
				
				for(int j=0; j<m; j++) {
					int[] c = chicken.get(numbers[j]);
					
					min = Math.min(min, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
				}
				sum += min;
			}
			
			ans = Math.min(ans, sum);
		}
		else {
			for(int i=start; i<totalChicken; i++) {
				numbers[depth] = i;
				dfs(depth + 1, i + 1);
			}
		}
	}
}
