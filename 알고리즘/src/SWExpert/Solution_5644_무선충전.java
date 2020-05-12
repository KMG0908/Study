package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	public static int m, bc;
	public static int a[], b[], ap[][];
	public static HashMap<Integer, ArrayList<Integer>> map;
	public static int[][] dir = { {0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			m = Integer.parseInt(st.nextToken()) + 1;
			bc = Integer.parseInt(st.nextToken());
			
			a = new int[m];
			b = new int[m];
			ap = new int[bc][4];
			
			map = new HashMap<>();
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map.put(i * 10 + j, new ArrayList<>());
				}
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<m; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<bc; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ap[i][1] = Integer.parseInt(st.nextToken()) - 1;
				ap[i][0] = Integer.parseInt(st.nextToken()) - 1;
				ap[i][2] = Integer.parseInt(st.nextToken());
				ap[i][3] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<bc; i++) {
				bfs(i, ap[i]);
			}
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(map.get(i * 10 + j).size() > 1) {
						Collections.sort(map.get(i * 10 + j), new Comparator<Integer>() {
							public int compare(Integer o1, Integer o2) {
								return ap[o2][3] - ap[o1][3];
							}
						});
					}
				}
			}
			
			int locA[] = new int[2];
			int locB[] = new int[2];
			
			locA[0] = locA[1] = 0;
			locB[0] = locB[1] = 9;
			
			int sum = 0;
			
			for(int k=0; k<m; k++) {
				locA[0] += dir[a[k]][0];
				locA[1] += dir[a[k]][1];
				
				locB[0] += dir[b[k]][0];
				locB[1] += dir[b[k]][1];
				
				ArrayList<Integer> listA = map.get(locA[0] * 10 + locA[1]);
				ArrayList<Integer> listB = map.get(locB[0] * 10 + locB[1]);
				
				int selectA = -1;
				int selectB = -1;
				
				if(listA.size() != 0 && listB.size() != 0) {
					selectA = listA.get(0);
					selectB = listB.get(0);
					
					if(selectA == selectB) {
						// A와 B모두 다른 것을 선택할 수 있을 경우
						if(listA.size() > 1 && listB.size() > 1) {
							if(ap[listA.get(1)][3] > ap[listB.get(1)][3]) {
								selectA = listA.get(1);
							}
							else selectB = listB.get(1);
						}
						else if(listA.size() > 1) {
							selectA = listA.get(1);
						}
						else if(listB.size() > 1) {
							selectB = listB.get(1);
						}
					}
					
					if(selectA == selectB) {
						sum += ap[selectA][3];
					}
					else {
						sum += ap[selectA][3] + ap[selectB][3];
					}
				}
				else if(listA.size() != 0) {
					selectA = listA.get(0);
					sum += ap[selectA][3];
				}
				else if(listB.size() != 0) {
					selectB = listB.get(0);
					sum += ap[selectB][3];
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
	public static void bfs(int index, int[] ap) {
		boolean visited[][] = new boolean[10][10];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {ap[0], ap[1], ap[2]});
		visited[ap[0]][ap[1]] = true;
		map.get(ap[0] * 10 + ap[1]).add(index);
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			
			int nr, nc;
			for(int i=1; i<5; i++) {
				nr = info[0] + dir[i][0];
				nc = info[1] + dir[i][1];
				
				if(nr >= 0 && nr < 10 && nc >= 0 && nc < 10 && !visited[nr][nc] && info[2] - 1 >= 0) {
					queue.offer(new int[] {nr, nc, info[2] - 1});
					visited[nr][nc] = true;
					
					map.get(nr * 10 + nc).add(index);
				}
			}
		}
	}
}
