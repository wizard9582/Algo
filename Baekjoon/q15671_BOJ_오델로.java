package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15671_BOJ_오델로 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = { { '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.' },
				{ '.', '.', 'W', 'B', '.', '.' }, { '.', '.', 'B', 'W', '.', '.' }, { '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.' } };
		char[][] save = new char[6][6];

		int N = Integer.parseInt(br.readLine());

		char player = 'B';
		char enemy = 'W';

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = player;

			for (int i = 0; i < 8; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				copy(map, save);

				while (isIn(nX, nY) && map[nX][nY] == enemy) {
					map[nX][nY] = player;
					nX += delta[i][0];
					nY += delta[i][1];
				}

				if (!isIn(nX, nY) || map[nX][nY] != player) {
					copy(save, map);
				}
			}

			char temp = player;
			player = enemy;
			enemy = temp;
		}

		int black = 0;
		int white = 0;

		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				sb.append(map[x][y]);
				if (map[x][y] == 'B') {
					black++;
				} else if (map[x][y] == 'W') {
					white++;
				}
			}
			sb.append("\n");
		}

		String winner = (black > white) ? "Black" : "White";
		sb.append(winner);

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < 6 && 0 <= y && y < 6) {
			return true;
		}
		return false;
	}

	static void copy(char[][] from, char[][] to) {
		for (int x = 0; x < 6; x++) {
			to[x] = from[x].clone();
		}
	}
}