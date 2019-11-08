package programmers;

import java.util.Arrays;

public class L1_K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int start = 0, end = 0, sequence = 0;
        	start = commands[i][0];
        	end = commands[i][1];
        	sequence = commands[i][2];
        	
        	int[] arr = new int[end-start+1];
        	
        	int index = 0;
        	for(int k=start-1; k<end; k++) {
        		arr[index++] = array[k];
        	}
        	
        	Arrays.sort(arr);
        	
        	answer[i] = arr[sequence-1];
        }
		
		for(int i=0; i<answer.length; i++) System.out.print(answer[i] + "\t");
	}
}
