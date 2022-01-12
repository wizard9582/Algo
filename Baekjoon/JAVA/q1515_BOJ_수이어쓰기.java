package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1515_BOJ_수이어쓰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int N = 0;
		
		for(int i = 0; i < input.length;) {
			
			N++;
			String now = Integer.toString(N);
			
			int j = 0;
			while(i < input.length && j < now.length()) {
				if(now.charAt(j) == input[i]) {
					i++;
				}
				j++;
			}
		}
		
		System.out.println(N);
	}
}
