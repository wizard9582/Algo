package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3109 {
	static StringTokenizer st;
	static int R, C, answer = 0;
	static char[][] map;
	static int[] delta = { -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			search(r, 0);
		}

		System.out.println(answer);
	}

	static boolean search(int x, int y) {
		map[x][y] = 'x';
		if (y == C - 1) {
			answer++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nX = x + delta[i];
			int nY = y + 1;

			if (isIn(nX, nY) && map[nX][nY] == '.') {
				if (search(nX, nY)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}