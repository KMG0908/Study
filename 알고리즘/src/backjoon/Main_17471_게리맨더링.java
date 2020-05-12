package backjoon;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_17471_게리맨더링 {
	public static int n, area, people[], villages[][], A[], B[], res = Integer.MAX_VALUE;
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		people = new int[n];		// 각 마을에 있는 인구 수
		villages = new int[n][n];	// 0: 인접한 마을이 아님, 1: 인접한 마을임
		
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int adjoin = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<adjoin; j++) {
				villages[i][Integer.parseInt(st.nextToken()) - 1] = 1; 
			}
		}
		
		for(int i=1; i<n/2+1; i++) {
			area = i;
			A = new int[i];
			B = new int[n - i];
			dfs(0, 0);
		}
		
		if(res == Integer.MAX_VALUE) res = -1;
		
		System.out.println(res);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == area) {
			int idxA = 0;
			int idxB = 0;
			for(int i=0; i<n; i++) {
				if(A[idxA] != i) {
					B[idxB++] = i;
				}
				else {
					if(idxA < area - 1) idxA++;
				}
			}
			
			visited = new boolean[n];
			for(int i=0; i<n-area; i++) {
				visited[B[i]] = true;
			}
			
			if(!bfs(A[0])) return;
			
			visited = new boolean[n];
			for(int i=0; i<area; i++) {
				visited[A[i]] = true;
			}
			
			if(!bfs(B[0])) return;
			
			int sumA = 0, sumB = 0;
			for(int i=0; i<area; i++) {
				sumA += people[A[i]];
			}
			
			for(int i=0; i<n-area; i++) {
				sumB += people[B[i]];
			}
			
			res = Math.min(res, Math.abs(sumA - sumB));
		}
		else {
			for(int i=start; i<n; i++) {
				A[depth] = i;
				dfs(depth + 1, i + 1);
			}
		}
	}
	
	public static boolean bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int j=0; j<n; j++) {
				if(!visited[j] && villages[tmp][j] == 1) {
					queue.offer(j);
					visited[j] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) return false;
		}
		
		return true;
	}
}
