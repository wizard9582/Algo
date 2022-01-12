package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3055 {
	static StringTokenizer st;
	static int R, C;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		Queue<int[]> queue = new LinkedList<>();
		int x = 0, y = 0, answer = 0;

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == '*') {
					queue.offer(new int[] { r, c, -1 });
				} else if (map[r][c] == 'S') {
					x = r;
					y = c;
				}
			}
		}

		visit[x][y] = true;
		queue.offer(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (now[2] < 0) {
				x = now[0];
				y = now[1];

				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];

					if (isIn(nX, nY) && map[nX][nY] != 'D' && map[nX][nY] != 'X' && map[nX][nY] != '*') {
						map[nX][nY] = '*';
						queue.offer(new int[] { nX, nY, -1 });
					}
				}
			} else {
				x = now[0];
				y = now[1];
				int l = now[2];

				if (map[x][y] == 'D') {
					answer = l;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];

					if (isIn(nX, nY)  && map[nX][nY] != 'X' && map[nX][nY] != '*' && !visit[nX][nY]) {
						visit[nX][nY] = true;
						queue.offer(new int[] { nX, nY, l + 1 });
					}
				}
			}
		}

		if (answer == 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(answer);
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}
