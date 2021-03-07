package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2828 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int apple = Integer.parseInt(br.readLine());

		int left = 1, right = M;
		int answer = 0;
		for (int a = 0; a < apple; a++) {
			N = Integer.parseInt(br.readLine());

			if (N < left) {
				answer += left - N;
				left = N;
				right = N + M - 1;
			} else if (right < N) {
				answer += N - right;
				right = N;
				left = N - M + 1;
			} else {
				continue;
			}
		}

		System.out.println(answer);
	}
}
