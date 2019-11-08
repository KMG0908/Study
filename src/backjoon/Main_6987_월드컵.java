package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {
	public static int score[][], total;
	public static boolean possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			score = new int[6][3];
			
			total = 0;
			
			possible = false;
			
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
					total += score[i][j];
				}
			}
			
			if(total == 30) recursive(0, 1);
			
			if(possible) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}
	
	public static void recursive(int team1, int team2) {
		if(team1 == 6) {
			possible = true;
		}
		else if(team2 == 6) {
			recursive(team1 + 1, team1 + 2);
		}
		else {
			score[team1][0]--;
			score[team2][2]--;
			if(score[team1][0] >= 0 && score[team2][2] >= 0) recursive(team1, team2 + 1);
			score[team1][0]++;
			score[team2][2]++;
			
			score[team1][1]--;
			score[team2][1]--;
			if(score[team1][1] >= 0 && score[team2][1] >= 0) recursive(team1, team2 + 1);
			score[team1][1]++;
			score[team2][1]++;
			
			score[team1][2]--;
			score[team2][0]--;
			if(score[team1][2] >= 0 && score[team2][0] >= 0) recursive(team1, team2 + 1);
			score[team1][2]++;
			score[team2][0]++;
		}
	}
}
