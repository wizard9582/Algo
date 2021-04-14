package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15988_BOJ_123더하기3 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp = new long[1000001];
		int div = 1000000009;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int n = 4; n <= 1000000; n++) {
			dp[n] = (dp[n - 1] + dp[n - 2] + dp[n - 3]) % div;
		}

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}

		System.out.println(sb);
	}
}
