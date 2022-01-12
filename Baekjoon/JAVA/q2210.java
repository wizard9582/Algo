package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2210 {
	static StringTokenizer st;
	static int answer = 0;
	static int[][] map = new int[5][5];
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] visit = new boolean[1000000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int n = 0; n < 5; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < 5; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int n = 0; n < 5; n++) {
			for (int m = 0; m < 5; m++) {
				dfs(n, m, map[n][m], 0);
			}
		}

		System.out.println(answer);
	}

	static void dfs(int x, int y, int sum, int count) {

		if (count == 5) {
			if (!visit[sum]) {
				visit[sum] = true;
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];

			if (isIn(nX, nY)) {
				dfs(nX, nY, sum * 10 + map[nX][nY], count + 1);
			}
		}

	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < 5 && 0 <= y && y < 5) {
			return true;
		}
		return false;
	}
}
