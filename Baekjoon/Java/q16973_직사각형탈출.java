package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16973_BOJ_직사각형탈출 {
	static StringTokenizer st;
	static int N, M, H, W;
	static int[][] check;
	static boolean[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		check = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				check[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken()) - 1;
		int startY = Integer.parseInt(st.nextToken()) - 1;
		int goalX = Integer.parseInt(st.nextToken()) - 1;
		int goalY = Integer.parseInt(st.nextToken()) - 1;

		map = new boolean[N - H + 1][M - W + 1];

		for (int n = 0; n <= N - H; n++) {
			for (int m = 0; m <= M - W; m++) {
				map[n][m] = canMove(n, m);
			}
		}

		int answer = -1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startX, startY, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int count = now[2];

			if (x == goalX && y == goalY) {
				answer = count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY) && map[nX][nY]) {
					queue.offer(new int[] { nX, nY, count + 1 });
					map[nX][nY] = false;
				}
			}
		}

		System.out.println(answer);
	}

	static boolean canMove(int x, int y) {

		for (int n = 0; n < H; n++) {
			for (int m = 0; m < W; m++) {
				if (check[x + n][y + m] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x <= N - H && 0 <= y && y <= M - W) {
			return true;
		}
		return false;
	}
}
