package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main_10827_ab {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" "); 
		BigDecimal big = new BigDecimal(arr[0]).pow(Integer.parseInt(arr[1])); 
		System.out.println(big.toPlainString());
	}
}
