package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2294_BOJ_동전2 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[K + 1];
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		int[] coin = new int[N];

		for (int n = 0; n < N; n++) {
			coin[n] = Integer.parseInt(br.readLine());
		}

		for (int n = 0; n < N; n++) {
			for (int k = coin[n]; k <= K; k++) {
				dp[k] = Math.min(dp[k], dp[k - coin[n]] + 1);
			}
		}

		if (dp[K] == 100000) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
	}
}
