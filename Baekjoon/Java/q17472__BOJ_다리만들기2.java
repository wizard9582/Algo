package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17472__BOJ_다리만들기2 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] parent;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken()) * -1;
			}
		}

		int island = 1;
		Queue<int[]> queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == -1) {
					queue.offer(new int[] { n, m });
					map[n][m] = island;

					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						int x = now[0];
						int y = now[1];

						for (int i = 0; i < 4; i++) {
							int nX = x + delta[i][0];
							int nY = y + delta[i][1];
							if (isIn(nX, nY) && map[nX][nY] == -1) {
								queue.offer(new int[] { nX, nY });
								map[nX][nY] = island;
							}
						}
					}
					island++;
				}
			}
		}

		int[][] graph = new int[island][island];

		for (int is = 1; is <= island; is++) {
			boolean[][] visit = new boolean[N][M];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[n][m] == is) {
						queue.offer(new int[] { n, m, 0, 5 });
						visit[n][m] = true;
					}
				}
			}

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int x = now[0];
				int y = now[1];
				int l = now[2];
				int dir = now[3];

				if (dir == 5) {
					for (int i = 0; i < 4; i++) {
						int nX = x + delta[i][0];
						int nY = y + delta[i][1];
						if (isIn(nX, nY) && !visit[nX][nY] && map[nX][nY] == 0) {
							queue.offer(new int[] { nX, nY, l + 1, i });
							visit[nX][nY] = true;
						}
					}
				}

				else {
					int nX = x + delta[dir][0];
					int nY = y + delta[dir][1];
					if (isIn(nX, nY) && !visit[nX][nY]) {

						if (map[nX][nY] == 0) {
							queue.offer(new int[] { nX, nY, l + 1, dir });
							visit[nX][nY] = true;
						} else {
							if (graph[is][map[nX][nY]] == 0 && 1 < l) {
								graph[is][map[nX][nY]] = l;
							}
							visit[nX][nY] = true;
						}
					}
				}
			}
		}

		int answer = 0;
		parent = new int[island];
		for (int n = 1; n < island; n++) {
			parent[n] = n;
		}
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((e1, e2) -> {
			return e1[0] - e2[0];
		});

		for (int from = 1; from < island; from++) {
			for (int to = 1; to < island; to++) {
				if (graph[from][to] != 0) {
					pqueue.offer(new int[] { graph[from][to], from, to });
				}
			}
		}

		while (!pqueue.isEmpty()) {
			int[] now = pqueue.poll();
			int l = now[0];
			int from = now[1];
			int to = now[2];

			if (find(from) != find(to)) {
				answer += l;
				union(from, to);
			}
		}

		boolean flag = false;
		int parent = find(1);
		for (int n = 1; n < island; n++) {
			if (find(n) != parent) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}

	static int find(int i) {
		if (i == parent[i])
			return i;
		return parent[i] = find(parent[i]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x > y)
			parent[x] = y;
		else
			parent[y] = x;
	}
}
