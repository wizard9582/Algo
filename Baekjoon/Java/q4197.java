package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q4197 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<>();

		int a = 0, b = 0;
		boolean flag = true;

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
				if (map[n][m] == 'J') {
					a = n;
					b = m;
				}
				if (map[n][m] == 'F') {
					queue.offer(new int[] { n, m, -1 });
				}
			}
		}

		queue.offer(new int[] { a, b, 1 });
		map[a][b] = '.';
		visit[a][b] = true;

		loop: while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int count = now[2];

			if (count == -1) {
				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];

					if (isIn(nX, nY) && map[nX][nY] == '.') {
						map[nX][nY] = 'F';
						queue.offer(new int[] { nX, nY, -1 });

					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];

					if (isIn(nX, nY)) {
						if (!visit[nX][nY] && map[nX][nY] == '.') {
							visit[nX][nY] = true;
							queue.offer(new int[] { nX, nY, count + 1 });
						}
					} else {
						flag = false;
						System.out.println(count);
						break loop;
					}
				}
			}
		}
		if (flag) {
			System.out.println("IMPOSSIBLE");
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
