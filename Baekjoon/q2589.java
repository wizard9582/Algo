package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2589 {
	static StringTokenizer st;
	static int N, M, answer = 0;
	static char[][] map;
	static boolean[][] visit;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		int x = 0, y = 0;

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 'L') {
					visit = new boolean[N][M];
					visit[n][m] = true;
					queue.offer(new int[] { n, m, 0 });

					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						x = now[0];
						y = now[1];
						int l = now[2];
						answer = Math.max(answer, l);
						
						for (int i = 0; i < 4; i++) {
							int nX = x + delta[i][0];
							int nY = y + delta[i][1];

							if (isIn(nX, nY) && !visit[nX][nY] && map[nX][nY] == 'L') {
								visit[nX][nY] = true;
								queue.offer(new int[] { nX, nY , l+1});
							}
						}
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
