package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {
	public static int parents[];
	
	static void make() {
		Arrays.fill(parents, -1);
	}
	
	static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		PriorityQueue<Value> queue = new PriorityQueue<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			queue.add(new Value(a, b, val));
		}
		
		int sum = 0;
		int count = 0;
		
		make();
		
		for(int i=0; i<m; i++) {
			Value value = queue.poll();
			if(union(value.a, value.b)) {
				sum += value.val;
				count++;
			}
			
			if(count == n - 2) break;
		}
		
		System.out.println(sum);
	}
	
	static class Value implements Comparable<Value> {
		int a;
		int b;
		int val;
		
		public Value(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		public int compareTo(Value o) {
			return this.val - o.val;
		}
	}
}
