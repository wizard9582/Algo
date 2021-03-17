package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1094 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for(int i = 0; i < 7; i ++) {
			if((N & (1 << i)) > 0) {
				answer ++;
			}
		}
		System.out.println(answer);
	}
}
