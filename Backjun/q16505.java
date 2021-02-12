package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16505 {
	static char[][] star;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		N = (int) Math.pow(2, N);
		StringBuilder sb = new StringBuilder();
		star = new char[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				star[i][j] = ' ';
			}
		}

		star(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				sb.append(star[i][j]);
			}
			if (i == N - 1)
				break;
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void star(int x, int y, int N) {
		if (N == 1) {
			star[x][y] = '*';
			return;
		}
		star(x, y, N / 2);
		star(x, y + N / 2, N / 2);
		star(x + N / 2, y, N / 2);

	}
}
