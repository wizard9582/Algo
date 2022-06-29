package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2003_BOJ_수들의합2 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int sum = 0;

		for (int left = 0, right = 0; right < N || (sum > M && left < N);) {
			if (sum <= M) {
				sum += arr[right];
				right++;
			} else {
				sum -= arr[left];
				left++;
			}

			if (sum == M) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
