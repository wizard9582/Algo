package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2178 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1 });
		map[0][0] = 1;
		int answer = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int l = now[2];

			if (x == N - 1 && y == M - 1) {
				answer = l;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY) && map[nX][nY] == 1) {
					map[nX][nY] = 2;
					queue.offer(new int[] { nX, nY, l + 1 });
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
