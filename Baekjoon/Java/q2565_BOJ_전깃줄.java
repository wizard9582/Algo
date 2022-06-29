package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2565_BOJ_전깃줄 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] wires = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			wires[n][0] = Integer.parseInt(st.nextToken());
			wires[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wires, (e1, e2) -> {
			return e1[0] - e2[0];
		});

		int[] dp = new int[N];

		for (int n = N - 1; n >= 0; n--) {
			dp[n] = 1;
			int end = wires[n][1];
			for (int m = n; m < N; m++) {
				if (wires[m][1] > end) {
					dp[n] = Math.max(dp[n], 1 + dp[m]);
				}
			}
		}

		int max = 0;

		for (int n = 0; n < N; n++) {
			max = Math.max(max, dp[n]);
		}

		System.out.println(N - max);

	}
}