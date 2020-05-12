package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	public static int n, m, k, ground[][], nutrient[][], treeSize;
	public static HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();
	public static int[][] dead;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ground = new int[n][n];
		for(int i=0; i<n; i++) Arrays.fill(ground[i], 5);
		nutrient = new int[n][n];
		dead = new int[n][n];
		treeSize = n * n;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				nutrient[i][j] = Integer.parseInt(st.nextToken()); 
				tree.put(i * n + j, new LinkedList<>());
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree.get((x - 1) * n + (y - 1)).add(age);
		}
		
		for(int i=0; i<k; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(check());
	}
	
	public static void spring() {
		Iterator<LinkedList<Integer>> iter = tree.values().iterator();
		
		int index = 0;
		
		while(iter.hasNext()) {
			List<Integer> info = iter.next();
			List<Integer> grow = new LinkedList<>();
			
			if(info.size() >= 1) {
				for(int j=0; j<info.size(); j++) {
					int age = info.get(j);
					
					if(age <= ground[index / n][index % n]) {
						ground[index / n][index % n] -= age;
						grow.add(age + 1);
					}
					else {
						dead[index / n][index % n] += age / 2;
					}
				}
				
				info.clear();
				info.addAll(grow);
			}
			index++;
		}
	}
	
	public static void summer() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ground[i][j] += dead[i][j];
				dead[i][j] = 0;
			}
		}
	}
	
	public static void fall() {
		int[][] dir = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
		
		Iterator<LinkedList<Integer>> iter = tree.values().iterator();
		
		int index = 0;
		
		while(iter.hasNext()) {
			Iterator<Integer> info = iter.next().iterator();
			
			while(info.hasNext()) {
				int age = info.next();
				
				if(age % 5 == 0) {
					int x = index / n;
					int y = index % n;
					
					int nr, nc;
					
					for(int k=0; k<8; k++) {
						nr = x + dir[k][0];
						nc = y + dir[k][1];
						
						if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
							tree.get(nr * n + nc).add(0, 1);
						}
					}
				}
			}
			
			index++;
		}
	}
	
	public static void winter() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ground[i][j] += nutrient[i][j];
			}
		}
	}
	
	public static int check() {
		int sum = 0;
		
		Iterator<LinkedList<Integer>> iter = tree.values().iterator();
		
		while(iter.hasNext()) {
			sum += iter.next().size();
		}
		
		return sum;
	}
}

