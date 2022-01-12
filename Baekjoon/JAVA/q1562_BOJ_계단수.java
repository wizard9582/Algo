package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1562_BOJ_계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = (1 << 10);
		int mod = 1_000_000_000;

		int[] bit = new int[10];
		for (int i = 0; i < 10; i++) {
			bit[i] = 1 << i;
		}

		int N = Integer.parseInt(br.readLine());
		int[][][] dp = new int[10][N + 1][max];

		for (int i = 1; i < 10; i++) {
			dp[i][1][bit[i]] = 1;
		}

		for (int n = 1; n < N; n++) {
			for (int j = 1; j < max; j++) {
				dp[1][n + 1][j | bit[1]] = (dp[1][n + 1][j | bit[1]] + dp[0][n][j]) % mod;
				for (int i = 1; i < 9; i++) {
					dp[i - 1][n + 1][j | bit[i - 1]] = (dp[i - 1][n + 1][j | bit[i - 1]] + dp[i][n][j]) % mod;
					dp[i + 1][n + 1][j | bit[i + 1]] = (dp[i + 1][n + 1][j | bit[i + 1]] + dp[i][n][j]) % mod;
				}
				dp[8][n + 1][j | bit[8]] = (dp[8][n + 1][j | bit[8]] + dp[9][n][j]) % mod;
			}
		}

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[i][N][max-1]) % mod;
		}

		System.out.println(sum);

	}
}
