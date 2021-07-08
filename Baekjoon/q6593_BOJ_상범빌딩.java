package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q6593_BOJ_상범빌딩 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, R, C;
	static int[][] delta = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			Queue<int[]> queue = new LinkedList<>();
			int[][][] map = new int[L][R][C];
			int[] goal = new int[3];

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String input = br.readLine();
					for (int c = 0; c < C; c++) {
						char now = input.charAt(c);
						if (now == '.') {
							map[l][r][c] = 0;
						} else if (now == '#') {
							map[l][r][c] = 1;
						} else if (now == 'S') {
							queue.offer(new int[] { l, r, c });
							map[l][r][c] = 1;
						} else {
							goal[0] = l;
							goal[1] = r;
							goal[2] = c;
							map[l][r][c] = 0;
						}
					}
				}
				br.readLine();
			}

			int time = 0;
			boolean flag = false;

			loop : while (!queue.isEmpty()) {
				int size = queue.size();

				while (size-- > 0) {
					int[] now = queue.poll();
					int l = now[0];
					int r = now[1];
					int c = now[2];

					if (l == goal[0] && r == goal[1] && c == goal[2]) {
						flag = true;
						break loop;
					}

					for (int i = 0; i < 6; i++) {
						int nl = l + delta[i][0];
						int nr = r + delta[i][1];
						int nc = c + delta[i][2];

						if (isIn(nl, nr, nc) && map[nl][nr][nc] == 0) {
							queue.offer(new int[] { nl, nr, nc });
							map[nl][nr][nc] = 1;
						}
					}
				}
				time++;
			}

			if (flag) {
				sb.append("Escaped in ").append(time).append(" minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
		}

		System.out.println(sb);
	}

	static boolean isIn(int l, int r, int c) {
		if (0 <= l && l < L && 0 <= r && r < R && 0 <= c && c < C) {
			return true;
		}
		return false;
	}
}
