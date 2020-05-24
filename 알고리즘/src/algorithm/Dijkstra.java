package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
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
		
		int start = 0, end = N - 1;
		int[] distance = new int[N];
		int[] path = new int[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		int min = Integer.MAX_VALUE, minIndex = 0;
		for(int i=0; i<N; i++) {
			min = Integer.MAX_VALUE;
			// step 1. 미방문 정점 중 최적 비용이 최소인 정점 찾기
			for(int j=0; j<N; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					minIndex = j;
				}
			}
			
			// step 2. 선택 정점 방문하고 경유지로 고려하여 미방문 정점들로 가는 최적 비용을 최적화
			visited[minIndex] = true;
			if(minIndex == end) break;
			for(int j=0; j<N; j++) {
				if(!visited[j] && input[minIndex][j] != 0 && min + input[minIndex][j] < distance[j]) {
					distance[j] = min + input[minIndex][j];
					path[j] = minIndex;
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}
