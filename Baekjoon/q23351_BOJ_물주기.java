package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q23351_BOJ_물주기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		N = N / A;

		int[] plant = new int[N];
		Arrays.fill(plant, K);

		int day = 0;

		while (true) {
			int min = 1000;
			int target = 0;
			for (int n = 0; n < N; n++) {
				if (plant[n] < min) {
					min = plant[n];
					target = n;
				}
			}

			if (min == 0) {
				break;
			} else {
				plant[target] += B;
			}
			for (int n = 0; n < N; n++) {
				plant[n]--;
			}

			day++;
		}

		System.out.println(day);
	}
}
