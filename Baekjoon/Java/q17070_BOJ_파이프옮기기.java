package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17070_BOJ_파이프옮기기 {
	static StringTokenizer st;
	static int N;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;

		for (int x = 0; x < N; x++) {
			for (int y = 2; y < N; y++) {
				if (canMove(x, y)) {
					dp[x][y][0] = dp[x][y - 1][0] + dp[x][y - 1][2];
					if (isIn(x - 1, y)) {
						dp[x][y][1] = dp[x - 1][y][1] + dp[x - 1][y][2];
					}
				}

				if (canMove(x, y) && isIn(x - 1, y) && canMove(x - 1, y) && isIn(x, y - 1) && canMove(x, y - 1)) {
					dp[x][y][2] = dp[x-1][y-1][0] + dp[x-1][y-1][1] + dp[x-1][y-1][2];
				}

			}
		}

		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}

	static boolean canMove(int x, int y) {
		if (map[x][y] == 0) {
			return true;
		}
		return false;
	}
}
