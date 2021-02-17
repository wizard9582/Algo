package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1992 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		quadTree(N, 0, 0);

			System.out.println(sb);

	}

	static void quadTree(int size, int x, int y) {

		if (size == 1) {
			sb.append(map[x][y]);
			return;
		}

		int num = check(size, x, y);
		if (num == -1) {
			sb.append("(");
			quadTree(size / 2, x, y);
			quadTree(size / 2, x, y + size / 2);
			quadTree(size / 2, x + size / 2, y);
			quadTree(size / 2, x + size / 2, y + size / 2);
			sb.append(")");
		} else {
			sb.append(num);
		}

	}

	static int check(int size, int x, int y) {
		int num = map[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (num != map[i][j]) {
					return -1;
				}
			}
		}
		return num;
	}
}
