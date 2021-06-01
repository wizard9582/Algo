package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1446_BOJ_지름길 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][3];
		int[] distance = new int[goal + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			list[n] = new int[] { from, to, dis };
		}

		Arrays.sort(list, (e1, e2) -> {
			return e1[0] - e2[0];
		});

		distance[0] = 0;
		int target = 0;

		for (int d = 0; d < goal; d++) {

			while (target < N && list[target][0] == d) {

				int to = list[target][1];
				int dis = list[target][2];

				if (to <= goal) {
					distance[to] = Math.min(distance[to], distance[d] + dis);
				}
				target++;
			}

			distance[d + 1] = Math.min(distance[d + 1], distance[d] + 1);
		}

		System.out.println(distance[goal]);
	}

}
