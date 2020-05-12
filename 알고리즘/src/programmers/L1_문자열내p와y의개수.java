package programmers;

public class L1_문자열내p와y의개수 {
	public static void main(String[] args) {
		String s = "pPoooy";
		boolean answer = true;
		
		char[] c = s.toCharArray();
		
		int cntP = 0, cntY = 0;
		
		for(int i=0; i<c.length; i++) {
			if(c[i] == 'P' || c[i] == 'p') cntP++; 
			else if(c[i] == 'Y' || c[i] == 'y') cntY++;
		}
		
		if(cntP != cntY) answer = false;
		
		System.out.println(answer);
	}
}
