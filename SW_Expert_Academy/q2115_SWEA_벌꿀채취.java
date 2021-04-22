package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2115_SWEA_벌꿀채취 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, C, maxHoney, answer;
	static int[][] honey;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					honey[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (c + M - 1 < N) {
						honey[r][c] = honeyCheck(r, c);
					} else {
						honey[r][c] = -1;
					}
				}
			}

			answer = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (honey[r][c] != -1) {
						int now = honey[r][c];
						now += chooseHoney(r, c + M);
						answer = Math.max(answer, now);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static int honeyCheck(int x, int y) {
		int[][] dp = new int[M + 1][C + 1];

		for (int m = 1; m <= M; m++) {
			int weight = honey[x][y + m - 1];
			int profit = honey[x][y + m - 1] * honey[x][y + m - 1];
			for (int cap = 1; cap <= C; cap++) {
				if (cap < weight) {
					dp[m][cap] = dp[m - 1][cap];
				} else {
					dp[m][cap] = Math.max(dp[m - 1][cap], dp[m - 1][cap - weight] + profit);
				}
			}
		}

		return dp[M][C];
	}

	static int chooseHoney(int x, int y) {
		int result = 0;

		for (int r = x; r < N; r++) {
			for (int c = y; c < N; c++) {
				result = Math.max(result, honey[r][c]);
			}
		}
		
		for (int r = x+1; r < N; r++) {
			for (int c = 0; c < N; c++) {
				result = Math.max(result, honey[r][c]);
			}
		}

		return result;
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
