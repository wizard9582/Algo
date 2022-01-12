package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5427 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new boolean[N][M];
			queue = new LinkedList<>();

			int a = 0, b = 0;

			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				for (int m = 0; m < M; m++) {
					map[n][m] = str.charAt(m);
					if (map[n][m] == '@') {
						a = n;
						b = m;
					}
					if (map[n][m] == '*') {
						queue.offer(new int[] { n, m, -1 });
					}
				}
			}

			queue.offer(new int[] { a, b, 1});
			map[a][b] = '.';
			visit[a][b] = true;
			boolean flag = true;
			
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
							map[nX][nY] = '*';
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
							sb.append(count).append("\n");
							flag = false;
							break loop;
						}
					}
				}
			}
			
			if(flag) {
				sb.append("IMPOSSIBLE").append("\n");
			}
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
