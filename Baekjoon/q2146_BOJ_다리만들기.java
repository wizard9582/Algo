package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2146_BOJ_다리만들기 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int[] parent;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken()) * -1;
			}
		}

		int island = 1;

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (map[n][m] == -1) {
					dfs(n, m, island);
					island++;
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		Queue<int[]> queue = new LinkedList<>();
		for (int is = 1; is <= island; is++) {
			boolean[][] visit = new boolean[N][N];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (map[n][m] == is) {
						queue.offer(new int[] { n, m });
						visit[n][m] = true;
					}
				}
			}

			int l = 0;

			while (!queue.isEmpty()) {
				int size = queue.size();

				for (int s = 0; s < size; s++) {

					int[] now = queue.poll();
					int x = now[0];
					int y = now[1];

					for (int i = 0; i < 4; i++) {
						int nX = x + delta[i][0];
						int nY = y + delta[i][1];
						if (isIn(nX, nY) && !visit[nX][nY]) {

							if (map[nX][nY] == 0) {
								queue.offer(new int[] { nX, nY });
								visit[nX][nY] = true;
							} else {
								answer = Math.min(answer, l);
								visit[nX][nY] = true;
							}
						}
					}
				}
				l++;
				if (l > answer) {
					queue.clear();
				}
			}
		}
		System.out.println(answer);

	}

	static void dfs(int x, int y, int name) {
		map[x][y] = name;

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			if (isIn(nX, nY) && map[nX][nY] == -1) {
				dfs(nX, nY, name);
			}
		}

	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
