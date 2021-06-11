package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9184_BOSJ_신나는함수실행 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[21][21][21];
		dp[0][0][0] = 1;
		dp[20][20][20] = 1048576;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int answer = 0;

			if (a == -1 && b == -1 && c == -1) {
				break;
			} else {
				answer = w(a, b, c);
				sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, answer));
			}
		}

		System.out.println(sb);
	}

	static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return dp[0][0][0];

		} else if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20];

		} else if (dp[a][b][c] != 0) {
			return dp[a][b][c];

		} else if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			
		} else {
			return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
			
		}
	}
}