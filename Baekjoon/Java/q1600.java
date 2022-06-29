package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1600 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int N, M, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][][] visit = new boolean[N][M][K + 1];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = -1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0, K });
		visit[0][0][K] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int l = now[2];
			int k = now[3];

			if (x == N - 1 && y == M - 1) {
				answer = l;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY) && (map[nX][nY] == 0) && !visit[nX][nY][k]) {
					visit[nX][nY][k] = true;
					queue.add(new int[] { nX, nY, l + 1, k });
				}
			}
			if (k > 0) {
				for (int i = 4; i < 12; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];

					if (isIn(nX, nY) && (map[nX][nY] == 0) && !visit[nX][nY][k - 1]) {
						visit[nX][nY][k - 1] = true;
						queue.add(new int[] { nX, nY, l + 1, k - 1 });
					}
				}
			}
		}

		System.out.println(answer);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
