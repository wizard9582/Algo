package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2206 {
	static StringTokenizer st;
	static int N, M, answer = 0;
	static char[][] map;
	static int[][] visit;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new int[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
			}
		}

		search(0, 0, 1, 2);
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			search(next[0], next[1], next[2], next[3]);
		}

		if (answer == 0) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static void search(int x, int y, int count, int wall) {
		
		if (x == N - 1 && y == M - 1) {
			answer = count;
			queue.clear();
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];

			if (isIn(nX, nY)) {
				if (map[nX][nY] == '0' && visit[nX][nY] < wall) {
					queue.offer(new int[] { nX, nY, count + 1, wall});
					visit[nX][nY] = wall;
				} else if (wall > 1 && visit[nX][nY] == 0) {
					queue.offer(new int[] { nX, nY, count + 1, wall - 1 });
					visit[nX][nY] = 1;
				}
			}
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
