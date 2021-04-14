package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1263_SWEA_사람네트워크2 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int inf = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] route = new int[N][N];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					route[n][m] = Integer.parseInt(st.nextToken());
					if (route[n][m] == 0) {
						route[n][m] = inf;
					}
					if (n == m) {
						route[n][m] = 0;
					}
				}
			}

			for (int n = 0; n < N; n++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						route[i][j] = Math.min(route[i][j], route[i][n] + route[n][j]);
					}
				}
			}

			answer = Integer.MAX_VALUE;
			for (int n = 0; n < N; n++) {
				int sum = 0;
				for (int m = 0; m < N; m++) {
					sum += route[n][m];
				}
				answer = Math.min(answer, sum);
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
