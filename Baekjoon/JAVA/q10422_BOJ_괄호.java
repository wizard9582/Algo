package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10422_BOJ_괄호 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;

		for (int i = 2; i <= 2500; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i * 2] %= 1000000007l;
			}
		}

		for (int tc = 0; tc < T; tc++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(dp[target]).append("\n");
		}

		System.out.println(sb);
	}
}
