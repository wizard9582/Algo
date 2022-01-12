package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1011_BOJ_AlphaCentauri {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			int distance = goal - start;
			int move = (int) Math.sqrt(distance);

			int answer = (move * move == distance) ? 2 * move - 1
					: ((distance <= move * move + move) ? 2 * move : 2 * move + 1);

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
