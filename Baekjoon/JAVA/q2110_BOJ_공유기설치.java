package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2110_BOJ_공유기설치 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] house = new int[N];
		for (int n = 0; n < N; n++) {
			house[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);

		int min = 0, max = house[N - 1];

		while (min <= max) {
			int center = (min + max) / 2;
			int count = 1;
			int before = house[0];

			for (int n = 1; n < N; n++) {
				if (center <= house[n] - before) {
					count++;
					before = house[n];
				}
			}

			if (count >= C) {
				min = center + 1;
			} else {
				max = center - 1;
			}
		}

		System.out.println(min-1);
	}
}
