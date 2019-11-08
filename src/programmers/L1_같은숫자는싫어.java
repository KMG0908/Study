package programmers;

public class L1_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		
		int[] answer = {};
		
		int a = arr[0];
		int cnt = 1;
		for(int i=0; i<arr.length; i++) {
			if(a != arr[i]) {
				a = arr[i];
				cnt++;
			}
		}
		
		answer = new int[cnt];
		
		a = arr[0];
		answer[0] = a;
		int index = 1;
		for(int i=0; i<arr.length; i++) {
			if(a != arr[i]) {
				a = arr[i];
				answer[index++] = arr[i];
			}
		}
		
		for(int i=0; i<answer.length; i++) System.out.println(answer[i]);
	}
}
