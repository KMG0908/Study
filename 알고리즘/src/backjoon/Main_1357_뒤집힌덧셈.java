package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1357_뒤집힌덧셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		StringBuffer a_ = new StringBuffer(a);
		StringBuffer b_ = new StringBuffer(b);
		
		a_.reverse();
		b_.reverse();
		
		int add = Integer.parseInt(a_.toString()) + Integer.parseInt(b_.toString());
		
		StringBuffer res = new StringBuffer(Integer.toString(add));
		res.reverse();
		
		System.out.println(Integer.parseInt(res.toString()));
	}
}
