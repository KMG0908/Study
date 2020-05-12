package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class L1_모의고사 {
	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};
		
		int[][] persons = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
		
		int[][] score = {{0, 1}, {0, 2}, {0, 3}};
		
		int[] answer = {};
		
		for(int i=0; i<persons.length; i++) {
			int index = 0;
			
			for(int j=0; j<answers.length; j++) {
				if(answers[j] == persons[i][index++]) score[i][0]++;
				
				if(index == persons[i].length) index = 0;
			}
		}
		
		Arrays.sort(score, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] > o2[1] ? o1[1] : o2[1];
			}
		});
		
		int max = score[0][0];
		
		for(int i=1; i<score.length; i++) {
			if(score[i][0] > max) max = score[i][0];
		}
		
		int cnt = 0;
		for(int i=0; i<score.length; i++) {
			if(max == score[i][0]) cnt++;
		}
		
		answer = new int[cnt];
		
		int index = 0;
		for(int i=0; i<score.length; i++) {
			if(max == score[i][0]) answer[index++] = score[i][1];
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
