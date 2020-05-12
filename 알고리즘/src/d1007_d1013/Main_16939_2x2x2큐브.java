package d1007_d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_16939_2x2x2큐브 {
	public static int cube[] = new int[24];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<24; i++) {
			cube[i] = Integer.parseInt(st.nextToken());
		}
		
		if(rotate(5, 7, 9, 11, 22, 20, 1, 3) || rotate(5, 7, 1, 3, 22, 20, 9, 11) || 
				rotate(2, 3, 16, 18, 9, 8, 15, 13) || rotate(2, 3, 15, 13, 9, 8, 16, 18) ||
				rotate(4, 5, 16, 17, 20, 21, 12, 13) || rotate(4, 5, 12, 13, 20, 21, 16, 17)) {
			System.out.println("1");
		}
		else System.out.println("0");
	}
	
	public static boolean rotate(int a, int b, int c, int d, int e, int f, int g, int h) {
		int[] copy = copy();
		
		int temp[] = new int[2];
		
		temp[0] = copy[a];
		temp[1] = copy[b];
		
		copy[a] = copy[c];
		copy[b] = copy[d];
		
		copy[c] = copy[e];
		copy[d] = copy[f];
		
		copy[e] = copy[g];
		copy[f] = copy[h];
		
		copy[g] = temp[0];
		copy[h] = temp[1];
		
		if(check(copy)) return true;
		return false;
	}
	
	public static boolean check(int[] copy) {
		for(int k=0; k<6; k++) {
			HashSet<Integer> set = new HashSet<>();
			
			set.add(copy[4 * k]);
			set.add(copy[4 * k + 1]);
			set.add(copy[4 * k + 2]);
			set.add(copy[4 * k + 3]);
			
			if(set.size() != 1) return false;
		}
		
		return true;
	}
	
	public static int[] copy(){
		return Arrays.copyOf(cube, 24);
	}
}
