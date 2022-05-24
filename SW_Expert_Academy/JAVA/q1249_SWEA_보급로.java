package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1249_SWEA_보급로 {
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int[][] map = new int[N][N];
			int[][] times = new int[N][N];

			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				for (int m = 0; m < N; m++) {
					map[n][m] = str.charAt(m) - '0';
				}
			}
			for (int n = 0; n < N; n++) {
				Arrays.fill(times[n], Integer.MAX_VALUE);
			}

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { 0, 0 });
			times[0][0] = 0;

			while (!queue.isEmpty()) {

				int[] now = queue.poll();
				int x = now[0];
				int y = now[1];

				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];
					if (isIn(nX, nY) && times[x][y] + map[nX][nY] < times[nX][nY]) {
						queue.offer(new int[] { nX, nY });
						times[nX][nY] = times[x][y] + map[nX][nY];
					}
				}

			}

			sb.append("#").append(tc).append(" ").append(times[N - 1][N - 1]).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
