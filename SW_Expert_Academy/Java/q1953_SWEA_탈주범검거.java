package keep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1953_SWEA_탈주범검거 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, R, C, L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			boolean[][][] map = new boolean[N][M][5];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					int type = Integer.parseInt(st.nextToken());

					switch (type) {
					case 0:
						break;
					case 1:
						map[n][m][1] = true;
						map[n][m][2] = true;
						map[n][m][3] = true;
						map[n][m][4] = true;
						break;
					case 2:
						map[n][m][1] = true;
						map[n][m][2] = true;
						break;
					case 3:
						map[n][m][3] = true;
						map[n][m][4] = true;
						break;
					case 4:
						map[n][m][1] = true;
						map[n][m][4] = true;
						break;
					case 5:
						map[n][m][2] = true;
						map[n][m][4] = true;
						break;
					case 6:
						map[n][m][2] = true;
						map[n][m][3] = true;
						break;
					case 7:
						map[n][m][1] = true;
						map[n][m][3] = true;
						break;
					}
				}
			}

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { R, C });
			map[R][C][0] = true;
			int time = 0;

			while (!queue.isEmpty()) {
				int size = queue.size();
				time++;
				if (time == L) {
					break;
				}
				for (int s = 0; s < size; s++) {

					int x = queue.peek()[0];
					int y = queue.poll()[1];

					if (map[x][y][1]) {
						int nX = x + delta[1][0];
						int nY = y + delta[1][1];
						if (isIn(nX, nY) && !map[nX][nY][0] && map[nX][nY][2]) {
							queue.offer(new int[] { nX, nY });
							map[nX][nY][0] = true;
						}
					}

					if (map[x][y][2]) {
						int nX = x + delta[2][0];
						int nY = y + delta[2][1];
						if (isIn(nX, nY) && !map[nX][nY][0] && map[nX][nY][1]) {
							queue.offer(new int[] { nX, nY });
							map[nX][nY][0] = true;
						}
					}

					if (map[x][y][3]) {
						int nX = x + delta[3][0];
						int nY = y + delta[3][1];
						if (isIn(nX, nY) && !map[nX][nY][0] && map[nX][nY][4]) {
							queue.offer(new int[] { nX, nY });
							map[nX][nY][0] = true;
						}
					}

					if (map[x][y][4]) {
						int nX = x + delta[4][0];
						int nY = y + delta[4][1];
						if (isIn(nX, nY) && !map[nX][nY][0] && map[nX][nY][3]) {
							queue.offer(new int[] { nX, nY });
							map[nX][nY][0] = true;
						}
					}

				}
			}

			answer = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m][0]) {
						answer++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
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
