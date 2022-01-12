package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10870_BOJ_피보나치수5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());	
		
		int answer = pibo(num);
		
		System.out.println(answer);
		
		}
	
	public static int pibo (int n) {
		
		if(n == 0) return 0;
		else if(n == 1) return 1;
		
		return (pibo(n-1) + pibo(n-2));
	}
}