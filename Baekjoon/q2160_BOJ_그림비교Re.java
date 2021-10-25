package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2160_BOJ_그림비교Re {
	static boolean[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new boolean[5 * N][7];

		for (int n = 0; n < 5 * N; n++) {
			String str = br.readLine();

			for (int i = 0; i < 7; i++) {
				if (str.charAt(i) == '.') {
					map[n][i] = false;
				} else {
					map[n][i] = true;
				}
			}
		}

		int[][] same = new int[N][N];

		for (int n = 0; n < N; n++) {
			for (int m = n + 1; m < N; m++) {
				same[n][m] = check(n * 5, m * 5);
			}
		}
		int Max = -1;
		int answer1 = 0;
		int answer2 = 0;
		for (int n = 0; n < N; n++) {
			for (int m = n + 1; m < N; m++) {
				if (same[n][m] > Max) {
					Max = same[n][m];
					answer1 = n;
					answer2 = m;
				}
			}
		}
		System.out.println((answer1 + 1) + " " + (answer2+1));
	}

	static int check(int n, int m) {
		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				if (map[n + i][j] == map[m + i][j]) {
					count++;
				}
			}
		}

		return count;
	}
}
