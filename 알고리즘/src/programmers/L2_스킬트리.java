package programmers;

import java.util.ArrayList;

public class L2_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = 0;
		
		String[] skill_ = skill.split("");
		
		int[][] sequence = new int[skill_trees.length][skill_.length];
		
		for(int i=0; i<skill_trees.length; i++) {
			for(int j=0; j<skill_.length; j++) {
				sequence[i][j] = skill_trees[i].indexOf(skill_[j]);
			}
		}
		
		for(int i=0; i<sequence.length; i++) {
			int flag1 = 1;
			for(int j=0; j<sequence[i].length; j++) {
				int flag2 = 1;
				if(sequence[i][j] == -1) {
					flag1 = 0;
					if(j != sequence[i].length - 1) {
						for(int k=j+1; k<sequence[i].length; k++) {
							if(sequence[i][k] != -1) {
								flag2 = 0;
								break;
							}
						}
					}
					
					int flag3 = 1;
					
					if(flag2 == 1) {
						if(j == sequence[i].length - 1) {
							for(int k=0; k<sequence[i].length-1; k++) {
								if(sequence[i][k] != -1 && sequence[i][k+1] != -1) {
									if(sequence[i][k] > sequence[i][k+1]) {
										flag3 = 0;
										break;
									}
								}
							}
							
							if(flag3 == 1) {
								answer++;
							}
						}
					}
					else break;
				}
			}
			
			if(flag1 == 1) {
				int flag4 = 1;
				for(int j=0; j<sequence[i].length-1; j++) {
					if(sequence[i][j] > sequence[i][j+1]) {
						flag4 = 0;
						break;
					}
				}
				
				if(flag4 == 1) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
