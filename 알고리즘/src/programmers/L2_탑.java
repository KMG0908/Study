package programmers;

public class L2_탑 {
	public static void main(String[] args) {
		int[] heights = {6, 9, 5, 7, 4};
		int[] answer = new int[heights.length];
		
		for(int i=heights.length-1; i>=0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		
		for(int i=0; i<answer.length; i++) System.out.println(answer[i]);
	}
}
