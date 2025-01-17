package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q2665_BOJ_미로만들기 {
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[][] wall = new int[N][N];
		for (int n = 0; n < N; n++) {
			Arrays.fill(wall[n], Integer.MAX_VALUE);
		}

		boolean[][] map = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			for (int m = 0; m < N; m++) {
				map[n][m] = input.charAt(m) == '0' ? false : true;
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int wallCount = now[2];

			for (int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];

				if (isIn(nX, nY)) {
					if (map[nX][nY] && wallCount < wall[nX][nY]) {
						queue.offer(new int[] { nX, nY, wallCount });
						wall[nX][nY] = wallCount;
					} else if (wallCount + 1 < wall[nX][nY]){
						queue.offer(new int[] { nX, nY, wallCount + 1 });
						wall[nX][nY] = wallCount + 1;
					}
				}
			}
		}

		System.out.println(wall[N - 1][N - 1]);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
