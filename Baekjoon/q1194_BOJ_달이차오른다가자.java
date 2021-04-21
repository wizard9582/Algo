package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1194_BOJ_달이차오른다가자 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		boolean[][][] visited = new boolean[R][C][64];

		Queue<Player> queue = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			String input = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == '0') {
					queue.offer(new Player(r, c, 0));
					visited[r][c][0] = true;
					map[r][c] = '.';
				}
			}
		}

		int time = 0;
		boolean flag = false;

		loop: while (!queue.isEmpty()) {
			int size = queue.size();
			time++;
			while (size-- > 0) {
				Player p = queue.poll();
				int x = p.x;
				int y = p.y;
				int key = p.key;

				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];
					if (isIn(nX, nY) && map[nX][nY] != '#' && !visited[nX][nY][key]) {
						if (map[nX][nY] == '.') {
							queue.offer(new Player(nX, nY, key));
							visited[nX][nY][key] = true;
						} else if (map[nX][nY] == '1') {
							flag = true;
							break loop;
						} else if (map[nX][nY] < 'a' && canOpen(map[nX][nY], key)) {
							queue.offer(new Player(nX, nY, key));
							visited[nX][nY][key] = true;
						} else if (map[nX][nY] >= 'a') {
							int nKey = (1 << (map[nX][nY] - 'a')) | key;
							queue.offer(new Player(nX, nY, nKey));
							visited[nX][nY][nKey] = true;
						}
					}
				}
			}

		}

		if (flag) {
			System.out.println(time);
		} else {
			System.out.println("-1");
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}

	static boolean canOpen(char door, int key) {
		if ((1 << (door - 'A') & key) > 0) {
			return true;
		}
		return false;
	}

	static class Player {
		int x, y, key;

		public Player(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
