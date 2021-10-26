package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2343_BOJ_기타레슨 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			right += arr[n];
			left = Math.max(left, arr[n]);
		}

		while (left <= right) {
			int center = (left + right) / 2;
			int count = 1;
			int remain = center;

			for (int n = 0; n < N; n++) {
				remain -= arr[n];
				if (remain < 0) {
					remain = center - arr[n];
					count++;
				}
			}

			if (count > M) {
				left = center + 1;
			} else {
				right = center - 1;
			}
		}

		System.out.println(left);
	}
}
