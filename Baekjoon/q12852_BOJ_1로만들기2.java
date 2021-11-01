package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12852_BOJ_1로만들기2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] from = new int[N + 1];
		arr[1] = 0;

		for (int n = 2; n <= N; n++) {
			arr[n] = arr[n - 1] + 1;
			from[n] = n - 1;

			if (n % 2 == 0 && (arr[n / 2] + 1) < arr[n]) {
				arr[n] = arr[n / 2] + 1;
				from[n] = n / 2;
			}
			if (n % 3 == 0 && (arr[n / 3] + 1) < arr[n]) {
				arr[n] = arr[n / 3] + 1;
				from[n] = n / 3;
			}
		}

		sb.append(arr[N]).append("\n");

		for (int n = N; n > 0;) {
			sb.append(n).append(" ");
			n = from[n];
		}

		System.out.println(sb);
	}
}