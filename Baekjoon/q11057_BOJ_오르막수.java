package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11057_BOJ_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];

		for (int n = 0; n < 10; n++) {
			dp[1][n] += 1;
		}

		for (int n = 2; n <= N; n++) {
			int sum = 0;
			for (int m = 0; m < 10; m++) {
				sum += dp[n - 1][m];
				sum %= 10007;
				dp[n][m] = sum;
			}
		}

		int answer = 0;
		for (int n = 0; n < 10; n++) {
			answer += dp[N][n];
		}

		System.out.println(answer % 10007);

	}
}
