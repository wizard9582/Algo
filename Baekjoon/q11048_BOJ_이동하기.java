package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11048_BOJ_이동하기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] answer = new int[N][M];

		answer[0][0] = map[0][0];
		for (int n = 1; n < N; n++) {
			answer[n][0] = map[n][0] + answer[n - 1][0];
		}
		for (int m = 1; m < M; m++) {
			answer[0][m] = map[0][m] + answer[0][m - 1];
		}

		for (int n = 1; n < N; n++) {
			for (int m = 1; m < M; m++) {
				answer[n][m] = Math.max(Math.max(answer[n][m - 1], answer[n - 1][m]), answer[n - 1][m - 1]) + map[n][m];
			}
		}
		System.out.println(answer[N - 1][M - 1]);
	}
}
