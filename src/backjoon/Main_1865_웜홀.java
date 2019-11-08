package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
	public static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int c=0; c<testCase; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Edge[] edges = new Edge[2 * m + w];
			
			int idx = 0;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges[idx++] = new Edge(s, e, t);
				edges[idx++] = new Edge(e, s, t);
			}
			
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges[idx++] = new Edge(s, e, -t);
			}
			
			int[] dist = new int[n + 1];
			Arrays.fill(dist, INF);
			dist[1] = 0;
			
			boolean cycle = false;
			
			for(int i=1; i<n+1; i++) {
				for (Edge edge : edges) {
					if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
						dist[edge.to] = dist[edge.from] + edge.cost;
						if(i == n) cycle = true;
					}
				}
			}
			
			if(cycle) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static class Edge {
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
