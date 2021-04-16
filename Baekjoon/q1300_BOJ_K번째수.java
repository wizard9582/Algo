package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1300_BOJ_K번째수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int min = 1, max = K;

		while (min <= max) {
			int center = (min + max) / 2;
			int count = 0;

			for (int n = 1; n <= N; n++) {
				count += Math.min(center / n, N);
			}

			if (K <= count) {
				max = center - 1;
			} else {
				min = center + 1;
			}
		}
		
		System.out.println(min);
	}
}
