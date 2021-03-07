package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1834 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		long answer = (N+1) * (N-1) * N / 2;
		
		System.out.println(answer);
	}
}
