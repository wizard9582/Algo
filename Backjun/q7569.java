package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7569 {
	static StringTokenizer st;
	static int N, M, H;
	static int[][][] tomato;
	static int[][] delta = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		int answer = 0;

		Queue<int[]> queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					if (tomato[h][n][m] == 1) {
						queue.offer(new int[] { h, n, m, 0 });
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int h = now[0];
			int x = now[1];
			int y = now[2];
			int day = now[3];

			for (int i = 0; i < 6; i++) {
				int nH = h + delta[i][0];
				int nX = x + delta[i][1];
				int nY = y + delta[i][2];

				if (isIn(nH, nX, nY) && tomato[nH][nX][nY] == 0) {
					queue.offer(new int[] { nH, nX, nY, day + 1 });
					tomato[nH][nX][nY] = 1;
				}
			}
			answer = day;
		}

		loop: for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomato[h][n][m] == 0) {
						answer = -1;
						break loop;
					}
				}
			}
		}

		System.out.println(answer);
	}

	static boolean isIn(int h, int x, int y) {
		if (0 <= h && h < H && 0 <= x && x < N  && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
