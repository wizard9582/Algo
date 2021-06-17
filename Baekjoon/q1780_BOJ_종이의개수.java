package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1780_BOJ_종이의개수 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] answer = { 0, 0, 0 };

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
		
		divNConq(N, 0, 0);
		
		sb.append(answer[0]).append("\n");
		sb.append(answer[1]).append("\n");
		sb.append(answer[2]).append("\n");

		System.out.println(sb);
	}

	static void divNConq(int size, int x, int y) {
		int res = checkPaper(size, x, y);

		if (res == 10) {
			size /= 3;
			for (int n = 0; n < 3; n++) {
				for (int m = 0; m < 3; m++) {
					divNConq(size, x + (n * size), y + (m * size));
				}
			}
		} else {
			answer[res + 1]++;
		}
	}

	static int checkPaper(int size, int x, int y) {
		int now = map[x][y];

		for (int n = 0; n < size; n++) {
			for (int m = 0; m < size; m++) {
				if (map[x + n][y + m] != now) {
					return 10;
				}
			}
		}

		return now;
	}
}
