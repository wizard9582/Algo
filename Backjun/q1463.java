package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		num[1] = 0;

		for (int n = 2; n <= N; n++) {
			num[n] = num[n-1] + 1;
			if (n % 2 == 0) {
				num[n] = Math.min(num[n], num[n/2]+1);
			}
			if (n % 3 == 0) {
				num[n] = Math.min(num[n], num[n/3]+1);
			}
		}
		
		System.out.println(num[N]);
	}
}
