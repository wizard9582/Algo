package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1495 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N + 1][M + 1];

		map[0][S] = true;

		st = new StringTokenizer(br.readLine());

		for (int n = 1; n <= N; n++) {
			int now = Integer.parseInt(st.nextToken());

			for (int m = 0; m <= M; m++) {
				if (map[n - 1][m]) {

					if (0 <= m - now && m - now <= M) {
						map[n][m - now] = true;
					}
					if (0 <= m + now && m + now <= M) {
						map[n][m + now] = true;
					}

				}
			}
		}

		boolean flag = true;
		for (int m = M; m >= 0; m--) {
			if (map[N][m]) {
				System.out.println(m);
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println("-1");
		}
	}
}
