package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q14938_BOJ_서강그라운드_플로이드와샬 {
	static StringTokenizer st;
	static int N, M, R, answer = 0;
	static int[] items;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		items = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			items[n] = Integer.parseInt(st.nextToken());
		}

		int[][] routes = new int[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			Arrays.fill(routes[n], 10000001);
			routes[n][n] = 0;
		}

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			routes[a][b] = Math.min(routes[a][b], length);
			routes[b][a] = Math.min(routes[b][a], length);
		}

		for (int n = 1; n <= N; n++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == n || j == n || i == j) {
						continue;
					} else {
						routes[i][j] = Math.min(routes[i][j], routes[i][n] + routes[n][j]);
					}
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			int sum = 0;
			for (int m = 1; m <= N; m++) {
				if (routes[n][m] <= M) {
					sum += items[m];
				}
			}
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}
