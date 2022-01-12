package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17490_BOJ_일감호에다리놓기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long count = 0l;

		int[] distance = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			distance[n] = Integer.parseInt(st.nextToken());
		}

		boolean[] block = new boolean[N];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			block[Integer.parseInt(st.nextToken()) - 1] = true;
		}

		if (M <= 1) {
			for (int n = 0; n < N; n++) {
				count = Math.min(count, distance[n]);
			}
		} else {
			int start = 0, now = 0, min = Integer.MAX_VALUE;
			for (int n = 0; n < N; n++) {
				if (block[n]) {
					now = n;
					start = n;
					break;
				}
			}

			do {
				min = Math.min(min, distance[now]);
				now++;
				if (now == N) {
					now = 0;
				}
				if (block[now]) {
					count += min;
					min = Integer.MAX_VALUE;
				}
			} while (now != start);

		}

		if (K >= count) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}
