package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1987_BOJ_알파벳 {
	static StringTokenizer st;
	static int R, C, answer = 0;
	static char[][] map;
	static boolean[] visit = new boolean[26];
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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

		visit[map[0][0] - 'A'] = true;
		search(0, 0, 1);

		System.out.println(answer);
	}

	static void search(int x, int y, int count) {
		// 쓸데없이 계속 찾는 경우 가지치기 가능
		// if(answer == 26) return;
		
		answer = Math.max(answer, count);

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];

			if (isIn(nX, nY)) {
				if (!visit[map[nX][nY] - 'A']) {
					visit[map[nX][nY] - 'A'] = true;
					search(nX, nY, count + 1);
					visit[map[nX][nY] - 'A'] = false;
				}
			}

		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}

		return false;
	}
}
