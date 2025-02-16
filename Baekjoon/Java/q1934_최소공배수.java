package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1934_BOJ_최소공배수 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {

			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long r = gcd(a, b);

			long answer = (a * b) / r;

			sb.append(answer).append("\n");

		}
		System.out.println(sb);
	}

	static long gcd(long a, long b) {

		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
