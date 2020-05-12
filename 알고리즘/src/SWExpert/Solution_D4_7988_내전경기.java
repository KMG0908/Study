package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7988_내전경기 {
	public static int k, size, team[];
	public static boolean synergy[][];
	public static HashMap<String, Integer> member;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++){
			k = Integer.parseInt(br.readLine());
			
			member = new HashMap<>();
			String info[][] = new String[k][2];
			int num = 0;
			
			// member 이름에 번호 붙이기 위해서 hashmap 사용
			for(int i=0; i<k; i++){
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				info[i][0] = st.nextToken();
				info[i][1] = st.nextToken();
				
				if(!member.containsKey(info[i][0])) member.put(info[i][0], num++); 
				if(!member.containsKey(info[i][1])) member.put(info[i][1], num++); 
			}
			
			size = member.size();
			synergy = new boolean[size][size];
			// visited 대신에 사용
			// -1일 경우 방문하지 않은 멤버임
			// 0, 1은 팀 번호
			team = new int[size];
			Arrays.fill(team, -1);

			// member 이름으로 들어온 시너지를 인접행렬로 변환
			for(int i=0; i<k; i++){
				int a = member.get(info[i][0]);
				int b = member.get(info[i][1]);
				
				synergy[a][b] = true;
				synergy[b][a] = true;
			}
			
			sb.append("#" + t + " ");
			sb.append(bfs() ? "Yes" : "No");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		team[0] = 0;
		
		while(!queue.isEmpty()){
			int i = queue.poll();
			for(int j=0; j<size; j++){
				if(synergy[i][j]){
					// 해당 멤버를 방문하지 않았다면 다른 팀에 배치
					if(team[j] == -1) {
						queue.offer(j);
						team[j] = (team[i] + 1) % 2;
					}
					// 해당 멤버를 방문했는데 현재 멤버와 팀이 같을 경우 시너지를 일으키는 조합이 같은 팀에 존재하는 것이므로 return false
					else if(team[i] == team[j]) return false;
				}
			}
		}
		
		return true;
	}
}
