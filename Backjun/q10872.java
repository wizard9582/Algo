package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10872 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());	
		
		int answer = facto(num);
		
		System.out.println(answer);
		
		}
	
	public static int facto (int n) {
		
		if(n == 0) return 1;
		
		return n*(facto(n-1));
	}
}
