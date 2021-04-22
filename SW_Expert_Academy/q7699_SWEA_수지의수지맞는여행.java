package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q7699_SWEA_수지의수지맞는여행 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, answer;
	static char[][] map;
	static boolean[] visit;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			visit = new boolean[26];

			for (int r = 0; r < R; r++) {
				String input = br.readLine();
				for (int c = 0; c < C; c++) {
					map[r][c] = input.charAt(c);
				}
			}
			visit[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int x, int y, int count) {
		if (answer == 26) {
			return;
		}
		answer = Math.max(answer, count);

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];

			if (isIn(nX, nY)) {
				if (!visit[map[nX][nY] - 'A']) {
					visit[map[nX][nY] - 'A'] = true;
					dfs(nX, nY, count + 1);
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
