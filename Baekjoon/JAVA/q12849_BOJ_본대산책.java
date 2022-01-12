package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12849_BOJ_본대산책 {
	static final long div = 1_000_000_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int D = Integer.parseInt(br.readLine());
		long[][] map = new long[D + 1][8];
		map[0][0] = 1;

		for (int d = 0; d < D; d++) {
			map[d + 1][0] = (map[d][1] + map[d][2]) % div;
			map[d + 1][1] = (map[d][0] + map[d][2] + map[d][3]) % div;
			map[d + 1][2] = (map[d][0] + map[d][1] + map[d][3] + map[d][5]) % div;
			map[d + 1][3] = (map[d][1] + map[d][2] + map[d][4] + map[d][5]) % div;
			map[d + 1][4] = (map[d][3] + map[d][5] + map[d][6]) % div;
			map[d + 1][5] = (map[d][2] + map[d][3] + map[d][4] + map[d][7]) % div;
			map[d + 1][6] = (map[d][4] + map[d][7]) % div;
			map[d + 1][7] = (map[d][5] + map[d][6]) % div;
		}

		System.out.println(map[D][0]);
	}
}