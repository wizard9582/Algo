package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11501_BOJ_주식 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] arr = new int[N];

			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}

			long answer = 0l;
			int lastHighPrice = arr[N - 1];

			for (int n = N - 2; n >= 0; n--) {
				if (arr[n] <= lastHighPrice) {
					answer += lastHighPrice - arr[n];
				} else {
					lastHighPrice = arr[n];
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
