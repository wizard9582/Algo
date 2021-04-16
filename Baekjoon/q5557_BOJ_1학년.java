package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5557_BOJ_1학년 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N-1][21];
		dp[0][num[0]] = 1;

		for (int n = 1; n < N-1; n++) {
			for (int i = 0; i <= 20; i++) {
				if (dp[n - 1][i] != 0) {
					if (0 <= i - num[n]) {
						dp[n][i - num[n]] += dp[n - 1][i];
					}
					if (i + num[n] <= 20) {
						dp[n][i + num[n]] += dp[n - 1][i];
					}
				}
			}
		}

		System.out.println(dp[N-2][num[N-1]]);

	}
}
