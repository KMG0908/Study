package SWExpert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4261_빠른휴대전화키패드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		char[][] alphabet = { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
				{'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			char[] s = st.nextToken().toCharArray();
			int n = Integer.parseInt(st.nextToken());
			int count = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			ing:
			for(int k=0; k<n; k++) {
				char[] word = st.nextToken().toCharArray();
				
				if(word.length != s.length) continue;
				
				for(int i=0; i<word.length; i++) {
					boolean flag = false;
					int len = alphabet[s[i] - '0'].length;
					for(int j=0; j<len; j++) {
						if(word[i] == alphabet[s[i] - '0'][j]) flag = true;
					}
					
					if(!flag) continue ing;
				}
				
				count++;
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}
