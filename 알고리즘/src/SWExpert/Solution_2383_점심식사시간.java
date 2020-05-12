package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	public static int stairsNum, stairs1[], stairs2[], stairs[][], room[][];
	public static int people, peoples[][], min;
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			people = 0;
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j] == 1) people++;
				}
			}
			
			peoples = new int[people][2];
			stairs = new int[2][2];
			
			int idxP = 0;
			int idxS = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(room[i][j] == 1) peoples[idxP++] = new int[] {i, j};
					else if(room[i][j] >= 2) stairs[idxS++] = new int[] {i, j};
				}
			}
			
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<=people; i++) {
				visited = new boolean[people];
				stairsNum = i;
				stairs1 = new int[i];
				stairs2 = new int[people-i];
				
				dfs(0, 0);
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth == stairsNum) {
			int idx1 = 0;
			int idx2 = 0;
			for(int i=0; i<people; i++) {
				if(idx1 < stairsNum) {
					if(i != stairs1[idx1]) {
						stairs2[idx2++] = i;
					}
					else idx1++;
				}
				else {
					stairs2[idx2++] = i;
				}
			}
			
			move();
		}
		else {
			for(int i=start; i<people; i++) {
				if(!visited[i]) {
					visited[i] = true;
					stairs1[depth] = i;
					dfs(i+1, depth+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void move() {
		ArrayList<Integer> downStairs1 = new ArrayList<>();
		ArrayList<Integer> downStairs2 = new ArrayList<>();
		ArrayList<Integer> waitStairs1 = new ArrayList<>();
		ArrayList<Integer> waitStairs2 = new ArrayList<>();
		
		for(int i=0; i<stairsNum; i++) {
			waitStairs1.add(Math.abs(stairs[0][0] - peoples[stairs1[i]][0]) + Math.abs(stairs[0][1] - peoples[stairs1[i]][1]));
		}
		
		for(int i=0; i<people-stairsNum; i++) {
			waitStairs2.add(Math.abs(stairs[1][0] - peoples[stairs2[i]][0]) + Math.abs(stairs[1][1] - peoples[stairs2[i]][1]));
		}
		
		Collections.sort(waitStairs1);
		Collections.sort(waitStairs2);
		
		int count = 0;
		
		while(true) {
			count++;
			
			// 계단 1에 있는 사람 내려가기
			for(int i=0; i<downStairs1.size(); i++) {
				int time = downStairs1.get(i) - 1;
				if(time < 0) {
					downStairs1.remove(i);
					i--;
				}
				else {
					downStairs1.set(i, time);
				}
			}
			
			// 계단으로 움직이기
			for(int i=0; i<waitStairs1.size(); i++) {
				int time = waitStairs1.get(i) - 1;
				if(time <= 0) {
					if(downStairs1.size() < 3) {
						if(time < 0) downStairs1.add(room[stairs[0][0]][stairs[0][1]] - 1);
						else downStairs1.add(room[stairs[0][0]][stairs[0][1]]);
						waitStairs1.remove(i);
						i--;
					}
					else {
						waitStairs1.set(i, time);
					}
				}
				else {
					waitStairs1.set(i, time);
				}
			}
			
			// 계단 2에 있는 사람 내려가기
			for(int i=0; i<downStairs2.size(); i++) {
				int time = downStairs2.get(i) - 1;
				if(time < 0) {
					downStairs2.remove(i);
					i--;
				}
				else {
					downStairs2.set(i, time);
				}
			}
			
			// 계단으로 움직이기
			for(int i=0; i<waitStairs2.size(); i++) {
				int time = waitStairs2.get(i) - 1;
				if(time <= 0) {
					if(downStairs2.size() < 3) {
						if(time < 0) downStairs2.add(room[stairs[1][0]][stairs[1][1]] - 1);
						else downStairs2.add(room[stairs[1][0]][stairs[1][1]]);
						
						waitStairs2.remove(i);
						i--;
					}
					else {
						waitStairs2.set(i, time);
					}
				}
				else {
					waitStairs2.set(i, time);
				}
			}
			
			if(downStairs1.size() == 0 && downStairs2.size() == 0 && waitStairs1.size() == 0 && waitStairs2.size() == 0) break;
		}
		
		min = Math.min(count, min);
	}
}
