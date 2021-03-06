package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2446 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int n = 1; n <= N; n++) {
			
			for (int m = 1; m < n; m++) {
				sb.append(' ');
			}
			for (int m = 1; m < (2*N)-(2*n)+2; m++) {
				sb.append('*');
			}
			
			sb.append("\n");
		}
		for (int n = N-1; n > 0; n--) {
			
			for (int m = 1; m < n; m++) {
				sb.append(' ');
			}
			for (int m = 1; m < (2*N)-(2*n)+2; m++) {
				sb.append('*');
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
