package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15989_BOJ_123더하기4 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[10_001][3];
		int T = Integer.parseInt(br.readLine());
		int idx = 3;

		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;

		for (int t = 0; t < T; t++) {
			int target = Integer.parseInt(br.readLine());

			if (target > idx) {
				for (int i = idx + 1; i <= target; i++) {
					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
					dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
				}
				idx = target;
			}
			
			int answer = dp[target][0] + dp[target][1] + dp[target][2];
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
