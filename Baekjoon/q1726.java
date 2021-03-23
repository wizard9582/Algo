package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1726 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] delta = { {}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][5];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Queue<Robot> queue = new LinkedList<>();
		queue.offer(new Robot(a, b, c, 0));

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		Robot target = new Robot(a, b, c, 0);

		while (!queue.isEmpty()) {
			Robot now = queue.poll();
			int x = now.x;
			int y = now.y;
			int dir = now.dir;
			int count = now.count;

			if (x == target.x && y == target.y && dir == target.dir) {
				System.out.println(count);
				break;
			}

			if (dir / 3 == 0) {
				if (!visit[x][y][3]) {
					queue.offer(new Robot(x, y, 3, count + 1));
					visit[x][y][3] = true;
				}
				if (!visit[x][y][4]) {
					queue.offer(new Robot(x, y, 4, count + 1));
					visit[x][y][4] = true;
				}
			} else {
				if (!visit[x][y][1]) {
					queue.offer(new Robot(x, y, 1, count + 1));
					visit[x][y][1] = true;
				}
				if (!visit[x][y][2]) {
					queue.offer(new Robot(x, y, 2, count + 1));
					visit[x][y][2] = true;
				}
			}

			for (int i = 0; i < 3; i++) {
				x += delta[dir][0];
				y += delta[dir][1];

				if (isIn(x, y) && map[x][y] == 0) {
					if (!visit[x][y][dir]) {
						queue.offer(new Robot(x, y, dir, count + 1));
						visit[x][y][dir] = true;
					}
				} else {
					break;
				}
			}

		}

	}

	static class Robot {
		int x, y, dir, count;

		Robot(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
	}

	static boolean isIn(int x, int y) {
		if (0 < x && x <= N && 0 < y && y <= M) {
			return true;
		}

		return false;
	}
}
