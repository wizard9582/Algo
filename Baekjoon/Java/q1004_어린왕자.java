package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1004_BOJ_어린왕자 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());

				int circleX = Integer.parseInt(st.nextToken());
				int circleY = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());

				boolean startIn = checkRange(startX, startY, circleX, circleY, range);
				boolean endIn = checkRange(endX, endY, circleX, circleY, range);

				if (startIn != endIn) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static boolean checkRange(int x, int y, int cx, int cy, int range) {

		return ((cx - x) * (cx - x) + (cy - y) * (cy - y)) < (range * range);
	}
}
