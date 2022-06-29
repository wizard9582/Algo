package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q12886_BOJ_돌그룹 {
	static StringTokenizer st;
	static boolean answerFlag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		int N3 = Integer.parseInt(st.nextToken());
		int sum = N1 + N2 + N3;

		boolean[][] visited = new boolean[sum + 1][sum + 1];

		Queue<int[]> queue = new LinkedList<>();
		visited[N1][N2] = true;
		queue.offer(new int[] { N1, N2 });

		while (!queue.isEmpty()) {
			N1 = queue.peek()[0];
			N2 = queue.poll()[1];
			N3 = sum - N1 - N2;

			if (N1 == N2 && N2 == N3) {
				answerFlag = true;
				break;
			}

			if (N1 != N2) {
				if (N1 < N2) {
					int n1 = N1 * 2;
					int n2 = N2 - N1;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				} else {
					int n1 = N2 * 2;
					int n2 = N1 - N2;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				}
			}
			
			if (N2 != N3) {
				if (N2 < N3) {
					int n1 = N2 * 2;
					int n2 = N3 - N2;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				} else {
					int n1 = N3 * 2;
					int n2 = N2 - N3;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				}
			}
			
			if (N1 != N3) {
				if (N1 < N3) {
					int n1 = N1 * 2;
					int n2 = N3 - N1;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				} else {
					int n1 = N3 * 2;
					int n2 = N1 - N3;

					if (!visited[n1][n2]) {
						visited[n1][n2] = true;
						queue.offer(new int[] { n1, n2 });
					}
				}
			}
		}

		if (answerFlag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
