package d1014_d1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3780_네트워크연결 {
	static int parents[], value[];
	
	public static void make() {
		Arrays.fill(parents, -1);
	}
	
	public static int find(int a) {
		if(parents[a] < 0) return a;
		
		int tmp = find(parents[a]);
		value[a] += value[parents[a]];
		parents[a] = tmp;
		
		return tmp;
	}
	
	// 센터 A를 기업 B에 연결 -> 이때 A의 센터는 B의 센터가 됨
	public static void union(int a, int b) {
		value[a] = Math.abs(a - b) % 1000;
		parents[a] = b;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			
			parents = new int[n + 1];
			value = new int[n + 1];
			make();
			
			while(true) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				String oper = st.nextToken();
				
				if(oper.equals("E")) {
					int a = Integer.parseInt(st.nextToken());
					find(a);
					System.out.println(value[a]);
				}
				else if(oper.equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
					union(a, b);
				}
				else break;
			}
		}
	}
}
