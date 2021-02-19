package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3234 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, answer, total;
	static Integer[] gram;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			total = 0;
			gram = new Integer[N];

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				gram[n] = Integer.parseInt(st.nextToken());
				total += gram[n];
			}
			total /= 2;

			makePermutation(0, new int[N], new boolean[N]);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void makePermutation(int count, int[] choosed, boolean[] visited) {
		if (count == N) {
			check(1, choosed, choosed[0], 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[count] = gram[i];
				makePermutation(count + 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	static void check(int count, int[] choosed, int left, int right) {
		if (count == N) {
			answer++;
			return;
		}
		if (total < left) {
			int num = 1;
			for (int i = 0; i < N - count; i++) {
				num *= 2;
			}
			answer += num;
			return;
		}

		if (left >= right + choosed[count]) {

			check(count + 1, choosed, left, right + choosed[count]);
		}
		check(count + 1, choosed, left + choosed[count], right);

	}
}
