package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1051_BOJ_숫자정사각형 {
	static StringTokenizer st;
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int answer = 0;

		for (int n = 0; n < N; n++) {
			char[] line = br.readLine().toCharArray();
			for (int m = 0; m < M; m++) {
				map[n][m] = line[m] - '0';
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				answer = findSquare(n, m, answer);
			}
		}

		System.out.println((answer + 1) * (answer + 1));
	}

	static int findSquare(int n, int m, int range) {

		int answer = range;

		while (n + range < N && m + range < M) {
			if (map[n][m] == map[n + range][m] && map[n][m] == map[n][m + range]
					&& map[n][m] == map[n + range][m + range]) {
				answer = range;
			}
			range++;
		}

		return answer;
	}
}
