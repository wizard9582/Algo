package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1868_SWEA_파핑파핑지뢰찾기{
	static char[][] map;
	static int[][] numMap;
	static boolean[][] visitMap;
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer;
		String str;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			numMap = new int[N][N];
			visitMap = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] == '*') {
						numMap[i][j] = -1;
						visitMap[i][j] = true;
					} else {
						numMap[i][j] = count(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (numMap[i][j] == 0 && !visitMap[i][j]) {
						answer++;
						visitMap[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visitMap[i][j]) {
						answer++;
					}
				}
			}

			sb.append("#" + tc + " " + answer + "\n");
		}

		System.out.println(sb);
	}

	static void dfs(int i, int j) {
		for (int a = 0; a < 8; a++) {
			int x = i + delta[a][0];
			int y = j + delta[a][1];

			if (isIn(x, y)) {
				if (!visitMap[x][y] && numMap[x][y] > 0) {
					visitMap[x][y] = true;
				} else if (!visitMap[x][y] && numMap[x][y] == 0) {
					visitMap[x][y] = true;
					dfs(x, y);
				}
			}
		}
	}

	static int count(int i, int j) {
		int count = 0;
		int x, y;
		for (int a = 0; a < 8; a++) {
			x = i + delta[a][0];
			y = j + delta[a][1];
			if (isIn(x,y)) {
				if (map[x][y] == '*') {
					count++;
				}
			}
		}

		return count;
	}

	static boolean isIn(int i, int j) {

		if (0 <= i && i < N && 0 <= j && j < N) {
			return true;
		}

		return false;
	}
}
