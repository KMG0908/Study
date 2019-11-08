package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> mul = new ArrayList<>();
			int[] bracket = new int[3];
			
			for(int k=0; k<p; k++) {
				String line = br.readLine();
				
				int dot = 0;
				while(line.charAt(dot)=='.') {
                    dot++;
                }
				
				for(int i=dot; i<line.length(); i++) {
					switch(line.charAt(i)) {
					case '(':
						bracket[0]++;
						break;
					case ')':
						bracket[0]--;
						break;
					case '{':
						bracket[1]++;
						break;
					case '}':
						bracket[1]--;
						break;
					case '[':
						bracket[2]++;
						break;
					case ']':
						bracket[2]--;
						break;
					}
				}
				
				mul.add(new int[] {dot, bracket[0], bracket[1], bracket[2]});
			}
			
			ArrayList<Integer> r = new ArrayList<>();
			ArrayList<Integer> c = new ArrayList<>();
			ArrayList<Integer> s = new ArrayList<>();
			
			for(int x=1; x<21; x++) {
				for(int y=1; y<21; y++) {
					ing:
					for(int z=1; z<21; z++) {
						for(int l=0; l<mul.size()-1; l++) {
							int[] temp = mul.get(l);
							if(mul.get(l+1)[0] - (x * temp[1] + y * temp[2] + z * temp[3]) != 0) continue ing;
						}
						
						// 가능한 해
						r.add(x);
						c.add(y);
						s.add(z);
					}
				}
			}
			
			sb.append("#" + t + " " + 0 + " ");
			bracket = new int[3];
			for(int k=0; k<q; k++) {
				String line = br.readLine();
				
				for(int i=0; i<line.length(); i++) {
					switch(line.charAt(i)) {
					case '(':
						bracket[0]++;
						break;
					case ')':
						bracket[0]--;
						break;
					case '{':
						bracket[1]++;
						break;
					case '}':
						bracket[1]--;
						break;
					case '[':
						bracket[2]++;
						break;
					case ']':
						bracket[2]--;
						break;
					}
				}
				
				ArrayList<Integer> answer = new ArrayList<>();
				for(int i=0; i<r.size(); i++) {
					int cnt = r.get(i) * bracket[0] + c.get(i) * bracket[1] + s.get(i) * bracket[2];
					if(!answer.contains(cnt)) answer.add(cnt);
				}
				
				if(k != q - 1) {
					// 해가 한 개일 경우
					if(answer.size() == 1) sb.append(answer.get(0) + " ");
					// 해가 여러개일 경우
					else sb.append("-1" + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
