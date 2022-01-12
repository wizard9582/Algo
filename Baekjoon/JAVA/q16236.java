package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16236 {
	static StringTokenizer st;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, answer;
	static int sharkX, sharkY, sharkSize = 2, sharkFood = 0, targetX, targetY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] == 9) {
					sharkX = n;
					sharkY = m;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();

		loop: while (true) {
			boolean flag = false;
			boolean[][] visit = new boolean[N][N];
			queue.add(new int[] { sharkX, sharkY });
			visit[sharkX][sharkY] = true;
			int move = 0;
			targetX = Integer.MAX_VALUE;
			targetY = Integer.MAX_VALUE;

			while (!queue.isEmpty()) {
				int queueSize = queue.size();
				boolean searchFlag = false;

				for (int i = 0; i < queueSize; i++) {
					int x = queue.peek()[0];
					int y = queue.poll()[1];

					if (map[x][y] != 0 && (map[x][y] < sharkSize) && (map[x][y] < 7)) {

						if (x < targetX) {
							targetX = x;
							targetY = y;
						} else if (targetX == x) {
							targetY = Math.min(targetY, y);
						}
						searchFlag = true;
					}

					for (int j = 0; j < 4; j++) {
						int newX = x + delta[j][0];
						int newY = y + delta[j][1];

						if (isIn(newX, newY) && !visit[newX][newY]) {
							if (map[newX][newY] <= sharkSize) {
								visit[newX][newY] = true;
								queue.add(new int[] { newX, newY });
							} else {
								visit[newX][newY] = true;
							}
						}
					}

				}

				if (searchFlag) {
					flag = true;
					queue.clear();
					answer += move;

					map[sharkX][sharkY] = 0;
					sharkX = targetX;
					sharkY = targetY;
					map[sharkX][sharkY] = 9;

					sharkFood++;
					if (sharkFood == sharkSize) {
						sharkSize++;
						sharkFood = 0;
					}

				}
				move++;
			}

			if (!flag) {
				break loop;
			}
		}

		System.out.println(answer);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
