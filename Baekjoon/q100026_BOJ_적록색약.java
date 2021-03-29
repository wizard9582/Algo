package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q100026_BOJ_적록색약 {
	static int N, answer;
	static char[][] map;
	static boolean[][] visit;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < N; m++) {
				map[n][m] = str.charAt(m);
			}
		}

		answer = 0;
		visit = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (!visit[n][m]) {
					search(map[n][m], n, m);
					answer++;
				}
			}
		}
		System.out.print(answer + " ");

		answer = 0;
		visit = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (!visit[n][m]) {
					searchRG(map[n][m], n, m);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	static void search(char c, int x, int y) {
		if (map[x][y] == c) {
			visit[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY)) {
					if (!visit[nX][nY]) {
						search(c, nX, nY);
					}
				}
			}

		} else {
			return;
		}
	}

	static void searchRG(char c, int x, int y) {
		if ((map[x][y] == 'B' && c == 'B') || (map[x][y] != 'B' && c != 'B')) {
			visit[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY)) {
					if (!visit[nX][nY]) {
						searchRG(c, nX, nY);
					}
				}
			}

		} else {
			return;
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}

		return false;
	}
}
