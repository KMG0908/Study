package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	public static int n, m, getPerson[], relationship[];
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		relationship = new int[n + 1];
		visited = new boolean[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		getPerson = new int[2];
		getPerson[0] = Integer.parseInt(st.nextToken());
		getPerson[1] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			relationship[child] = parent;
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(getPerson[0]);
		visited[getPerson[0]] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			
			for(int i=0; i<size; i++){
				int person = queue.poll();
				
				if(person == getPerson[1]) return cnt;
				
				if(relationship[person] != 0 && !visited[relationship[person]]){
					queue.offer(relationship[person]);
					visited[relationship[person]] = true;
				}
				
				for(int j=1; j<=n; j++){
					if(relationship[j] == person && !visited[j]){
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
}
