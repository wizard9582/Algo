package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1740 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		long answer = 0;
		int count = 0;
		
		while(N != 0) {
			if((N & 1) == 1) {
				long sum = 1;
				for(int i = 0; i < count; i++) {
					sum = sum * 3;
				}
				answer = answer + sum;
			}
			N = N >> 1;
			count ++;
		}
		System.out.println(answer);
	
	}
}

