package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1904_BOJ_01타일 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(1);
		} else {
			int[] dp = new int[N + 1];
			dp[0] = 1;
			dp[1] = 1;

			for (int n = 2; n <= N; n++) {
				dp[n] = (dp[n-1] + dp[n-2]) % 15746;
			}

			System.out.println(dp[N]);
		}
	}
}
