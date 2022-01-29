package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q17829_BOJ_222풀링 {
	static StringTokenizer st;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(div(N, 0, 0));

	}

	static int div(int size, int x, int y) {

		if (size == 1) {
			return map[x][y];
		} else {
			int[] candi = new int[4];
			size /= 2;
			candi[0] = div(size, x, y);
			candi[1] = div(size, x + size, y);
			candi[2] = div(size, x, y + size);
			candi[3] = div(size, x + size, y + size);
			Arrays.sort(candi);
			//System.out.println(size + " " + x + "," + y + " = " + candi[2]);
			return candi[2];
		}
	}
}
