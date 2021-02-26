package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1926 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int N, M, Max, area;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		Max = 0;
		int count = 0;

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 1) {
					count++;
					area = 0;
					dfs(n, m);
					Max = Math.max(area, Max);
				}
			}
		}

		System.out.printf("%d\n%d", count, Max);
	}

	static void dfs(int x, int y) {
		area++;
		map[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];

			if (isIn(nX, nY) && map[nX][nY] == 1) {
				dfs(nX, nY);
			}

		}
	}

	static boolean isIn(int x, int y) {

		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}

		return false;
	}
}
