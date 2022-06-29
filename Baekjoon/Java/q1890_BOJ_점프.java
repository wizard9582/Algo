package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1890_BOJ_점프 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		dp[0][0] = 1;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for (int n = 0; n < N; n++) {
			if(n < N-1) {
				for (int m = 0; m < N; m++) {
					if(m + map[n][m] < N) {
						dp[n][m + map[n][m]] += dp[n][m];
					}
					if(n + map[n][m] < N) {
						dp[n + map[n][m]][m] += dp[n][m];
					}
				}
			}else {
				for (int m = 0; m < N-1; m++) {
					if(m + map[n][m] < N) {
						dp[n][m + map[n][m]] += dp[n][m];
					}
					if(n + map[n][m] < N) {
						dp[n + map[n][m]][m] += dp[n][m];
					}
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}
