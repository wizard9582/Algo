package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10836_BOJ_여왕벌 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] bees = new int[M][M];
		int[] grow = new int[2 * M - 1];

		for (int m = M - 1; m >= 0; m--) {
			bees[m][0] += 1;
		}

		for (int m = 1; m < M; m++) {
			bees[0][m] += 1;
		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int target = 0;

			for (int i = 0; i < 3; i++) {
				int count = Integer.parseInt(st.nextToken());
				for (int j = 0; j < count; j++) {
					grow[target++] = i;
				}
			}

			target = 0;

			for (int m = M - 1; m >= 0; m--) {
				bees[m][0] += grow[target++];
			}

			for (int m = 1; m < M; m++) {
				bees[0][m] += grow[target++];
			}
		}

		for (int n = 1; n < M; n++) {
			for (int m = 1; m < M; m++) {
				bees[n][m] = Math.max(bees[n - 1][m - 1], Math.max(bees[n - 1][m], bees[n][m - 1]));
			}
		}

		for (int n = 0; n < M; n++) {
			for (int m = 0; m < M; m++) {
				sb.append(bees[n][m]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
