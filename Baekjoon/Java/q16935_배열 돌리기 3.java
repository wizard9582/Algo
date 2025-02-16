package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16935 {
	static int[][] map;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; ++i) {
			int order = Integer.parseInt(st.nextToken());

			switch (order) {
			case 1:
				matrix1();
				break;
			case 2:
				matrix2();
				break;
			case 3:
				matrix3();
				break;
			case 4:
				matrix4();
				break;
			case 5:
				matrix5();
				break;
			case 6:
				matrix6();
				break;
			}
		}
		for (int r = 0; r < map.length; ++r) {
			for (int c = 0; c < map[0].length; ++c) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void matrix1() {
		for (int c = 0; c < map[0].length; ++c) {
			for (int r1 = 0, r2 = map.length - 1; r1 < r2; r1++, r2--) {
				int temp = map[r1][c];
				map[r1][c] = map[r2][c];
				map[r2][c] = temp;
			}
		}
	}

	private static void matrix2() {
		for (int r = 0; r < map.length; ++r) {
			for (int c1 = 0, c2 = map[0].length - 1; c1 < c2; c1++, c2--) {
				int temp = map[r][c1];
				map[r][c1] = map[r][c2];
				map[r][c2] = temp;
			}
		}
	}

	private static void matrix3() {
		int[][] result = new int[map[0].length][map.length];

		for (int r = 0; r < map.length; ++r) {
			for (int c = 0; c < map[0].length; ++c) {
				result[c][map.length - 1 - r] = map[r][c];
			}
		}

		map = result;
	}

	private static void matrix4() {
		int[][] result = new int[map[0].length][map.length];

		for (int r = 0; r < result.length; ++r) {
			for (int c = 0; c < result[0].length; ++c) {
				result[r][c] = map[c][result.length - 1 - r];
			}
		}

		map = result;
	}

	private static void matrix5() {
		int[][] result = new int[map.length][map[0].length];
		int rowSize = map.length;
		int colSize = map[0].length;

		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r][c + colSize / 2] = map[r][c];
			}
		}
		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r + rowSize / 2][c] = map[r][c];
			}
		}
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r][c - colSize / 2] = map[r][c];
			}
		}
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r - rowSize / 2][c] = map[r][c];
			}
		}
		map = result;
	}

	private static void matrix6() {
		int[][] result = new int[map.length][map[0].length];

		int rowSize = map.length;
		int colSize = map[0].length;

		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r + rowSize / 2][c] = map[r][c];
			}
		}
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r][c + colSize / 2] = map[r][c];
			}
		}
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r - rowSize / 2][c] = map[r][c];
			}
		}
		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r][c - colSize / 2] = map[r][c];
			}
		}

		map = result;
	}
}