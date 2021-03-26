package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1263Re {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] route = new int[N + 1][N + 1];
			int[][] dist = new int[N + 1][N + 1];

			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= N; m++) {
					route[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			for (int n = 1; n <= N; n++) {
				boolean[] visit = new boolean[N + 1];

				Queue<Integer> queue = new LinkedList<>();
				queue.offer(n);
				visit[n] = true;
				int distance = 0;
				while (!queue.isEmpty()) {
					int size = queue.size();

					for (int s = 0; s < size; s++) {
						int now = queue.poll();
						dist[n][now] = distance;

						for (int m = 1; m <= N; m++) {
							if (!visit[m] && route[now][m] == 1) {
								queue.offer(m);
								visit[m] = true;
							}
						}
					}
					distance++;
				}
			}

			answer = Integer.MAX_VALUE;
			for (int n = 1; n <= N; n++) {
				int sum = 0;
				for (int m = 1; m <= N; m++) {
					sum += dist[n][m];
				}
				answer = Math.min(answer, sum);
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
