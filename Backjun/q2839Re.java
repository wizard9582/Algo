package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2839Re {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = N/5; i>-1; i--) {
			if((N - 5*i)%3==0) {
			System.out.println( i + (N - 5*i)/3);
			System.exit(0);
			}
		}

		System.out.println(-1);
	}
}