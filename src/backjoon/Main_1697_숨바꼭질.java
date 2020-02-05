package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	public static int n, k, dir[] = {1, -1, 2};
	public static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		if(n == k) return 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int loc = queue.poll();
				
				if(loc == k) return cnt;
				
				int nr;
				for(int j=0; j<3; j++){
					if(j == 2) nr = loc * dir[j];
					else nr = loc + dir[j];
					if(nr >= 0 && nr <= 100000 && !visited[nr]){
						queue.offer(nr);
						visited[nr] = true;
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
}
