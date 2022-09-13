package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1303_BOJ_전쟁전투 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int B = 0;
		int W = 0;

		int[][] map = new int[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();

		for (int n = 0; n < N; n++) {
			char[] line = br.readLine().toCharArray();
			for (int m = 0; m < M; m++) {
				map[n][m] = (line[m] == 'W') ? 0 : 1;
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 0 || map[n][m] == 1) {
					int target = map[n][m];
					int count = 0;
					queue.offer(new int[] { n, m });
					map[n][m] = -1;

					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						count += 1;

						for (int i = 0; i < 4; i++) {
							int nx = now[0] + delta[i][0];
							int ny = now[1] + delta[i][1];

							if (isIn(nx, ny, N, M) && map[nx][ny] == target) {
								queue.offer(new int[] { nx, ny });
								map[nx][ny] = -1;
							}
						}

					}

					if (target == 0) {
						W += (count * count);
					} else {
						B += (count * count);
					}
				}
			}
		}

		sb.append(W).append(" ").append(B);

		System.out.println(sb);
	}

	private static boolean isIn(int x, int y, int n, int m) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
