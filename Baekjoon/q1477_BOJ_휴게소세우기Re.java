package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1477_BOJ_휴게소세우기Re {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		if (L - N - 1 == M) {
			System.out.println(1);
		} else {

			int[] restArea = new int[N + 2];
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				restArea[n] = Integer.parseInt(st.nextToken());
			}
			restArea[N + 1] = L;
			Arrays.sort(restArea);

			int max = 0, min = 0;
			for (int n = 0; n <= N; n++) {
				max = Math.max(max, restArea[n + 1] - restArea[n]);
			}

			while (min <= max) {
				int center = Math.max((min + max) / 2, 1);
				int count = 0;

				for (int n = 0; n <= N; n++) {
					if (restArea[n + 1] > restArea[n]) {
						count += (restArea[n + 1] - restArea[n] - 1) / center;
					}
				}

				if (count > M) {
					min = center + 1;
				} else {
					max = center - 1;
				}
			}
			System.out.println(min);
		}

	}
}
