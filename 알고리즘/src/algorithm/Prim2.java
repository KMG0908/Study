package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 인접행렬 생성
		
		ArrayList<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE, minIndex = 0, result = 0;
		boolean[] visited = new boolean[N];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		// 임의의 시작점
		queue.offer(new Node(0, 0));
		
		Node cur = null;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			if(visited[cur.vertex]) continue;	// 이미 처리된 정점이라면 stkip
			
			visited[cur.vertex] = true;
			result += cur.weight;
			
			if(++cnt == N) break;
			
			// cur 정점 기준으로 인접행렬보며 방문하지 않은 정점 queue에 넣기
			for(int j=0; j<N; j++) {
				if(!visited[j] && input[cur.vertex][j] != 0 && input[cur.vertex][j] < min) {
					queue.offer(new Node(j, input[cur.vertex][j]));
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
}
