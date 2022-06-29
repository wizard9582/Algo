package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1913_BOJ_달팽이 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int x = -1, y = 0;
		int now = N * N;

		for (int n = 0; n < N; n++) {
			x++;
			map[x][y] = now;
			now--;
		}
		int count = N - 1;
		int idx = 0;
		while (true) {
			if (count == 0) {
				break;
			}

			for (int n = 0; n < count; n++) {
				x += delta[idx][0];
				y += delta[idx][1];
				map[x][y] = now;
				now--;
			}

			if (idx % 2 != 0) {
				count--;
			}
			idx = (idx + 1) % 4;
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				sb.append(map[n][m]).append(" ");
				if (map[n][m] == target) {
					x = n + 1;
					y = m + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(x).append(" ").append(y);

		System.out.println(sb);
	}
}
