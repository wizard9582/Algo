package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q8382_SWEA_방향전환 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int aX = Integer.parseInt(st.nextToken());
			int aY = Integer.parseInt(st.nextToken());
			int bX = Integer.parseInt(st.nextToken());
			int bY = Integer.parseInt(st.nextToken());
			int x = Math.abs(aX - bX);
			int y = Math.abs(aY - bY);

			answer = Math.abs(x - y) % 2 == 0 ? 2 * Math.max(x, y) : 2 * Math.max(x, y) - 1;

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
