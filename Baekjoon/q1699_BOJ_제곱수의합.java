package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1699_BOJ_제곱수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			dp[n] = n;
		}

		int num = 2;

		while ((num * num) <= N) {
			int square = num * num;
			for (int n = square; n <= N; n++) {
				dp[n] = Math.min(dp[n - square] + 1, dp[n]);
			}
			num++;
		}
		System.out.println(dp[N]);
	}
}