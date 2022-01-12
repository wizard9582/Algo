package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3036_BOJ_링 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N - 1; n++) {
			int now = Integer.parseInt(st.nextToken());
			int div = gcd(start, now);

			sb.append(start / div).append("/").append(now / div).append("\n");
		}

		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			int r = a % b;
			return gcd(b, r);
		}
	}
}
