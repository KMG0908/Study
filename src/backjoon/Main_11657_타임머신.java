package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657_타임머신 {
	static int count, edgeCount;
	static int INF = Integer.MAX_VALUE;
	static int[] distance;
	static Edge[] edges;
	
	static class Edge{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		count = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		distance = new int[count];
		edges = new Edge[edgeCount];
		
		for(int i=0; i<edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.fill(distance, INF);
		distance[0] = 0;
		
		if(goNegativeCycle()) {
			System.out.println("-1");
		}
		else {
			for(int d=1; d<count; d++) {
				System.out.println(distance[d] == INF ? -1 : distance[d]);
			}
		}
	}
	
	public static boolean goNegativeCycle() {
		// 간선리스트를 N - 1번(음수 싸이클 확인 : N번) 반복하며 간선완화 작업
		for(int i=1; i<=count; i++) {
			for(Edge e : edges) {
				if(distance[e.from] == INF) continue;	// 1번 도시에서 from까지 최소 비용이 INF이면 다음 간선
				if(distance[e.from] + e.weight < distance[e.to]) {
					distance[e.to] = distance[e.from] + e.weight;
					if(i == count) return true;
				}
			}
		}
		
		return false;
	}
}
