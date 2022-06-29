package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1756_BOJ_피자굽기 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] oven = new int[D];

		st = new StringTokenizer(br.readLine());
		for (int d = 0; d < D; d++) {
			oven[d] = Integer.parseInt(st.nextToken());
		}

		int before = oven[0];

		for (int d = 1; d < D; d++) {
			if (oven[d] > before) {
				oven[d] = before;
			} else {
				before = oven[d];
			}
		}

		int depth = 1;
		int n = 0;
		st = new StringTokenizer(br.readLine());
		while (n < N && depth <= D) {
			int pizza = Integer.parseInt(st.nextToken());
			n++;
			while (depth <= D) {
				if (oven[D - depth] >= pizza) {
					if (n == N) {
						depth--;
					}
					depth++;
					break;
				}
				depth++;
			}
		}

		System.out.println(D - depth + 1);
	}
}
