package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3307_SWEA_최장증가부분수열 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;

			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N + 1];
			int[] dp = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}

			for (int n = 1; n <= N; n++) {
				int inc = 0;
				for (int i = 0; i < n; i++) {
					if (num[i] < num[n]) {
						inc = Math.max(inc, dp[i]);
					}
					dp[n] = inc + 1;
				}
				answer = Math.max(answer, dp[n]);
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
