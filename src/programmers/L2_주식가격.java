package programmers;

public class L2_주식가격 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length-1; i++) {
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
				else if(j == prices.length-1) {
					answer[i] = j - i;
				}
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
