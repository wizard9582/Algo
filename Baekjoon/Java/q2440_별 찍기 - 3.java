package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2440 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			for(int m = N-n; m > 0; m--) {
				sb.append('*');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
