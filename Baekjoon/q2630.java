package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2630 {
	static StringTokenizer st;
	static int[][] map;
	static int N;
	static int[] wb = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		Color(0, 0, N);

		System.out.println(wb[0]);
		System.out.println(wb[1]);
	}

	static void Color(int x, int y, int n) {
		if (n == 1) {
			wb[map[x][y]]++;
			return;
		}

		int start = map[x][y];

		loop: for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[i][j] != start) {
					start = -1;
					break loop;
				}
			}
		}

		if (start == -1) {
			Color(x, y, n / 2);
			Color(x + n / 2, y, n / 2);
			Color(x, y + n / 2, n / 2);
			Color(x + n / 2, y + n / 2, n / 2);
		} else {
			wb[start]++;
			return;
		}
	}
}
