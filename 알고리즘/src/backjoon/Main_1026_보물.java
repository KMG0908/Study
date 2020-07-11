package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1026_보물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			list.add(b[i]);
		}
		
		Collections.sort(list);
		Arrays.sort(a);
		
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			// b[i]가 몇번째 수인지 찾기
			// 가장 큰 수일수록 A 배열에서 가장 작은 수와 곱해야 함
			int idx = list.indexOf(b[i]);
			sum += a[n - idx - 1] * b[i];
			// list에 같은 값이 존재할 경우 indexOf를 할 경우 제일 처음 것이 나올 가능성이 있으므로
			// 쓴 것은 사용한 값으로 만들기
			list.set(idx, -1);
		}
		
		System.out.println(sum);
	}
}
