package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1309_BOJ_동물원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][3];

		dp[1] = new int[] { 1, 1, 1 };

		for (int n = 2; n <= N; n++) {
			dp[n][0] = (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901;
			dp[n][1] = (dp[n - 1][0] + dp[n - 1][2]) % 9901;
			dp[n][2] = (dp[n - 1][0] + dp[n - 1][1]) % 9901;
		}

		int answer = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
		System.out.println(answer);
	}
}
