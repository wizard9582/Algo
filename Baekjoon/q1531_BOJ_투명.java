package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1531_BOJ_투명 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[101][101];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			for (int x = startX; x <= endX; x++) {
				for (int y = startY; y <= endY; y++) {
					map[x][y]++;
				}
			}
		}

		int answer = 0;

		for (int x = 1; x <= 100; x++) {
			for (int y = 1; y <= 100; y++) {
				if (map[x][y] > M) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
