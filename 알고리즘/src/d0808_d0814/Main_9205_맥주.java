package d0808_d0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주 {
	public static String str = "sad";
	public static int[] store[], arrive;
	public static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int t=0; t<testCase; t++) {
			str = "sad";
			
			int storeN = Integer.parseInt(br.readLine());
			store = new int[storeN][2];
			visited = new boolean[storeN];
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] location = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			for(int i=0; i<storeN; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			arrive = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			if(Math.abs(arrive[0] - location[0]) + Math.abs(arrive[1] - location[1]) <= 1000) {
				str = "happy";
			}
			if(!str.equals("happy")){
				//dfs(location[0], location[1], -1);
				bfs(location[0], location[1]);
			}
			
			System.out.println(str);
		}
	}
	
	public static void dfs(int x, int y, int index) {
		if(Math.abs(arrive[0] - x) + Math.abs(arrive[1] - y) <= 1000) str = "happy";
		if(str == "happy") return;
		
		if(index != -1) visited[index] = true;
		
		for(int i=0; i<store.length; i++) {
			if(Math.abs(store[i][0] - x) + Math.abs(store[i][1] - y) <= 1000 && !visited[i]) {
				dfs(store[i][0], store[i][1], i);
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			if(Math.abs(arrive[0] - info[0]) + Math.abs(arrive[1] - info[1]) <= 1000) {
				str = "happy";
				return;
			}
			
			for(int i=0; i<store.length; i++) {
				if(Math.abs(store[i][0] - info[0]) + Math.abs(store[i][1] - info[1]) <= 1000 && !visited[i]) {
					queue.offer(new int[] {store[i][0], store[i][1], i});
					visited[i] = true;
				}
			}
		}
	}
}
