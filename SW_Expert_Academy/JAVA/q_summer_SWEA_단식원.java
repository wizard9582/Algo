package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_summer_SWEA_단식원 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, answer;
	static int[][] map;
	static ArrayList<int[]> chicken;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			chicken = new ArrayList<>();

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
					if (map[n][m] == 2) {
						chicken.add(new int[] { n, m });
					}
				}
			}

			dfs(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int count, int h, int w) {
		if (count == 3) {
			answer = Math.max(answer, checkCount(map));
			return;
		}
		int[][] save = new int[N][M];

		for (int m = w; m < M; m++) {
			if (map[h][m] == 0) {
				copy(map, save);
				map[h][m] = 3;

				dfs(count + 1, h, m);

				copy(save, map);
			}
		}

		for (int n = h + 1; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 0) {
					copy(map, save);
					map[n][m] = 3;

					dfs(count + 1, n, m);

					copy(save, map);
				}
			}
		}
	}

	static void copy(int[][] from, int[][] to) {
		for (int n = 0; n < N; n++) {
			to[n] = from[n].clone();
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}

	static int checkCount(int[][] res) {
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < chicken.size(); i++) {
			int[] smell = chicken.get(i);

			visited[smell[0]][smell[1]] = true;
			queue.offer(smell);
		}

		while (!queue.isEmpty()) {
			int[] smell = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = smell[0] + delta[i][0];
				int nY = smell[1] + delta[i][1];

				if (isIn(nX, nY) && !visited[nX][nY] && res[nX][nY] == 0) {
					res[nX][nY] = 2;
					visited[nX][nY] = true;
					queue.offer(new int[] { nX, nY });
				}
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (res[n][m] == 0) {
					count++;
				}
			}
		}

		return count;
	}
}
