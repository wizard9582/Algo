package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1912_BOJ_연속합 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] dp = new int[N];
		dp[0] = Integer.parseInt(st.nextToken());

		for (int n = 1; n < N; n++) {
			int now = Integer.parseInt(st.nextToken());
			dp[n] = Math.max(dp[n - 1] + now, now);
		}

		int answer = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			answer = Math.max(answer, dp[n]);
		}

		System.out.println(answer);
	}
}
