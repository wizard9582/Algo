package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1389 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[][] friend;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		friend = new int[N + 1][N + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int min = Integer.MAX_VALUE, answer = 0;
		for (int n = 1; n <= N; n++) {
			queue.offer(new int[] { n, 0 });

			while (!queue.isEmpty()) {
				int[] next = queue.poll();

				friend[n][next[0]] = next[1];
				for (int i = 1; i <= N; i++) {
					if (i != n && map[next[0]][i] == 1 && friend[n][i] == 0) {
						queue.offer(new int[] { i, next[1] + 1 });
					}
				}

			}
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i != n) {
					sum += friend[n][i];
				}
			}
			if (sum < min) {
				min = sum;
				answer = n;
			}
		}

		System.out.println(answer);
	}
}
