package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2251 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean[][][] visit = new boolean[C + 1][C + 1][C + 1];
		boolean[] answer = new boolean[C + 1];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, C });
		visit[0][0][C] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			int a = now[0];
			int b = now[1];
			int c = now[2];

			if (a > 0) {
				if (a + b > B) {
					if (!visit[a + b - B][B][c]) {
						queue.offer(new int[] { a + b - B, B, c });
						visit[a + b - B][B][c] = true;
					}

				} else {
					if (!visit[0][a + b][c]) {
						queue.offer(new int[] { 0, a + b, c });
						visit[0][a + b][c] = true;
					}
				}
				if (a + c > C) {
					if (!visit[a + c - C][b][C]) {
						queue.offer(new int[] { a + c - C, b, C });
						visit[a + c - C][b][C] = true;
					}

				} else {
					if (!visit[0][b][a + c]) {
						queue.offer(new int[] { 0, b, a + c });
						visit[0][b][a + c] = true;
					}
				}
			}

			if (b > 0) {
				if (a + b > A) {
					if (!visit[A][a + b - A][c]) {
						queue.offer(new int[] { A, a + b - A, c });
						visit[A][a + b - A][c] = true;
					}

				} else {
					if (!visit[a + b][0][c]) {
						queue.offer(new int[] { a + b, 0, c });
						visit[a + b][0][c] = true;
					}
				}
				if (b + c > C) {
					if (!visit[a][b + c - C][C]) {
						queue.offer(new int[] { a, b + c - C, C });
						visit[a][b + c - C][C] = true;
					}

				} else {
					if (!visit[a][0][b + c]) {
						queue.offer(new int[] { a, 0, b + c });
						visit[a][0][b + c] = true;
					}
				}
			}

			if (c > 0) {
				if (a + c > A) {
					if (!visit[A][b][a + c - A]) {
						queue.offer(new int[] { A, b, a + c - A });
						visit[A][b][a + c - A] = true;
					}

				} else {
					if (!visit[a + c][b][0]) {
						queue.offer(new int[] { a + c, b, 0 });
						visit[a + c][b][0] = true;
					}
				}
				if (b + c > B) {
					if (!visit[a][B][b + c - B]) {
						queue.offer(new int[] { a, B, b + c - B });
						visit[a][B][b + c - B] = true;
					}

				} else {
					if (!visit[a][b + c][0]) {
						queue.offer(new int[] { a, b + c, 0 });
						visit[a][b + c][0] = true;
					}
				}
			}

			if (a == 0) {
				answer[c] = true;
			}
		}

		for (int i = 0; i <= C; i++) {
			if (answer[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}
