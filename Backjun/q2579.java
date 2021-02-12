package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2579 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		for(int n = N; n>=1; n++) {
			stair[n] = Integer.parseInt(br.readLine());
		}
		
		
	}
}