package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1520_BOJ_내리막길 {
	static StringTokenizer st;
	static int M, N;
	static int[][] map;
	static int[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new int[M][N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(visited[m], -1);

		}
		visited[M - 1][N - 1] = 1;

		dfs(0, 0);

		System.out.println(visited[0][0]);
	}

	static int dfs(int x, int y) {
		if (visited[x][y] != -1) {
			return visited[x][y];
		}

		visited[x][y] = 0;

		int now = map[x][y];
		int nX, nY, res = 0;
		for (int i = 0; i < 4; i++) {
			nX = x + delta[i][0];
			nY = y + delta[i][1];

			if (isIn(nX, nY) && now > map[nX][nY]) {
				res += dfs(nX, nY);
			}
		}
		visited[x][y] = res;
		return res;
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < M && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}