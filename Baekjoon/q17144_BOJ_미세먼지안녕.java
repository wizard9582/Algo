package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17144_BOJ_미세먼지안녕 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] ac;
	static int R, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		ac = new int[2][2];
		int idx = 0;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == -1) {
					map[r][c] = 0;
					ac[idx][0] = r;
					ac[idx++][1] = c;
				}
			}
		}

		int up = ac[0][0];
		int down = ac[1][0];

		for (int t = 0; t < T; t++) {
			int[][] spreads = new int[R][C];

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] != 0) {

						int spread = map[r][c] / 5;

						for (int i = 0; i < 4; i++) {
							int nR = r + delta[i][0];
							int nC = c + delta[i][1];

							if (isIn(nR, nC)) {
								spreads[nR][nC] += spread;
								map[r][c] -= spread;
							}
						}
					}
				}
			}

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] += spreads[r][c];
				}
			}

			int temp = map[0][0];

			for (int c = 1; c < C; c++) {
				map[0][c - 1] = map[0][c];
			}
			for (int r = 0; r < up; r++) {
				map[r][C - 1] = map[r + 1][C - 1];
			}
			for (int c = C - 1; c > 0; c--) {
				map[up][c] = map[up][c - 1];
			}
			for (int r = up; r > 1; r--) {
				map[r][0] = map[r - 1][0];
			}
			map[1][0] = temp;

			temp = map[down][0];

			for (int r = down; r < R - 1; r++) {
				map[r][0] = map[r + 1][0];
			}
			for (int c = 0; c < C - 1; c++) {
				map[R - 1][c] = map[R - 1][c + 1];
			}
			for (int r = R - 1; r > down; r--) {
				map[r][C - 1] = map[r - 1][C - 1];
			}
			for(int c = C-1; c > 1; c--) {
				map[down][c] = map[down][c-1];
			}
			map[down][1] = temp;

			map[up][ac[0][1]] = 0;
			map[down][ac[1][1]] = 0;
		}

		int dust = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				dust += map[r][c];
			}
		}

		System.out.println(dust);
	}

	static boolean isIn(int x, int y) {

		if ((x == ac[0][0] && y == ac[0][1]) || (x == ac[1][0] && y == ac[1][1])) {
			return false;
		}

		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}
