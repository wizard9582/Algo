package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2629_BOJ_양팔저울 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] grams = new int[N + 1];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			grams[n] = Integer.parseInt(st.nextToken());
			sum += grams[n];
		}

		int M = Integer.parseInt(br.readLine());
		int[] marbs = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			marbs[m] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N + 1][sum + 1];
		dp[0][0] = true;

		for (int n = 1; n <= N; n++) {
			int gram = grams[n];
			for (int m = 0; m <= sum; m++) {
				if (dp[n - 1][m]) {
					dp[n][m] = true;
					dp[n][m + gram] = true;
					dp[n][Math.abs(m - gram)] = true;
				}
			}
		}

		for (int m = 0; m < M; m++) {
			if (marbs[m] > sum) {
				sb.append("N ");
			} else if (dp[N][marbs[m]]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}

		System.out.println(sb);
	}
}
