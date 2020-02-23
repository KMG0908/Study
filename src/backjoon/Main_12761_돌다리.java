package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761_돌다리 {
	public static int a, b, n, m, dir_add[], dir_mul[];
	public static boolean visited[] = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dir_add = new int[]{1, -1, a, -a, b, -b};
		dir_mul = new int[]{a, b};
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0; i<size; i++){
				int loc = queue.poll();
				
				if(loc == m) return cnt;
				
				int nr;
				for(int j=0; j<6; j++){
					nr = loc + dir_add[j];
					
					if(nr >= 0 && nr <= 100000 && !visited[nr]){
						queue.offer(nr);
						visited[nr] = true;
					}
				}
				
				for(int j=0; j<2; j++){
					nr = loc * dir_mul[j];
					
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
