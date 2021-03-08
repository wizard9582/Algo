package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2448 {
	static StringBuilder sb = new StringBuilder();
	static boolean map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new boolean[N][2 * N];

		star(N, 0, N - 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				if(map[i][j]) {
					sb.append('*');
				}else {
					sb.append(' ');
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void star(int N, int x, int y) {

		if (N == 3) {
			map[x][y] = true;
			map[x + 1][y - 1] = true;
			map[x + 1][y + 1] = true;
			map[x + 2][y + 2] = true;
			map[x + 2][y + 1] = true;
			map[x + 2][y] = true;
			map[x + 2][y - 1] = true;
			map[x + 2][y - 2] = true;
			return;
		} else {
			star(N / 2, x, y);
			star(N / 2, x + (N / 2), y - (N / 2));
			star(N / 2, x + (N / 2), y + (N / 2));
		}

	}
}
