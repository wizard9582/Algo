package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10942_BOJ_팰린드롬 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
			dp[n][1] = 1;
		}
		for (int n = 2; n <= N; n++) {
			if (num[n - 1] == num[n]) {
				dp[n][2] = 1;
			}
		}
		for (int l = 3; l <= N; l++) {
			for (int n = l; n <= N; n++) {
				if (dp[n - 1][l - 2] == 1 && num[n - l + 1] == num[n]) {
					dp[n][l] = 1;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(dp[end][end - start + 1]).append("\n");
		}
		System.out.println(sb);
	}
}
