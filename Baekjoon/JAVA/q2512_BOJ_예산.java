package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2512_BOJ_예산 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] country = new int[N];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int budget = Integer.parseInt(br.readLine());
		int min = 1;
		int max = 0;

		for (int n = 0; n < N; n++) {
			country[n] = Integer.parseInt(st.nextToken());
			max = Math.max(max, country[n]);
			sum += country[n];
		}

		if (sum <= budget) {
			System.out.println(max);
		} else {
			max--;

			while (min + 1 < max) {
				int center = (min + max) / 2;
				sum = 0;

				for (int n = 0; n < N; n++) {
					sum += Math.min(country[n], center);
				}

				if (sum <= budget) {
					min = center;
				} else {
					max = center;
				}
			}
			System.out.println(min);
		}
	}
}
