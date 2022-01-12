package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11053 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N];

		st = new StringTokenizer(br.readLine());
		int answer = 1;

		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
			dp[n] = 1;

			for (int i = 0; i < n; i++) {
				if (num[i] < num[n] && dp[i] >= dp[n]) {
					dp[n] = dp[i] + 1;
				}
			}

			answer = Math.max(answer, dp[n]);
		}

		System.out.println(answer);

	}
}
