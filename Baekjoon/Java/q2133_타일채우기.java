package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2133_BOJ_타일채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 1) {
			System.out.println(0);
		} else {
			int[] dp = new int[N + 1];
			dp[2] = 3;

			for (int n = 4; n <= N; n += 2) {
				dp[n] = dp[n - 2] * dp[2];
				for (int m = n - 4; m > 0; m -= 2) {
					dp[n] += dp[m] * 2;
				}
				dp[n] += 2;
			}

			System.out.println(dp[N]);
		}
	}
}
