package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17826_나의학점은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<50; i++){
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int rank = list.indexOf(Integer.parseInt(br.readLine())) + 1;
		
		if(rank >= 1 && rank <= 5) System.out.println("A+");
		else if(rank >= 6 && rank <= 15) System.out.println("A0");
		else if(rank >= 16 && rank <= 30) System.out.println("B+");
		else if(rank >= 31 && rank <= 35) System.out.println("B0");
		else if(rank >= 36 && rank <= 45) System.out.println("C+");
		else if(rank >= 46 && rank <= 48) System.out.println("C0");
		else  System.out.println("F");
	}
}
