package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2156_BOJ_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] wines = new int[N];
		int[][] dp = new int[N][3];

		for (int n = 0; n < N; n++) {
			wines[n] = Integer.parseInt(br.readLine());
		}

		dp[0][0] = 0;
		dp[0][1] = wines[0];

		for (int n = 1; n < N; n++) {
			dp[n][0] = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
			dp[n][1] = dp[n-1][0] + wines[n];
			dp[n][2] = dp[n-1][1] + wines[n];
		}
		
		System.out.println(Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2])));
	}
}
