package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3234_SWEA_준환이의양팔저울Re {
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

			makePermutation(0, new boolean[N], 0, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void makePermutation(int count, boolean[] visited, int left, int right) {
		// System.out.println(count + "선택됨," + left + " : " + right);

		if (count == N) {
			answer++;
			return;
		}

		if (total < left) {
			int num = 1;
			for (int i = 1; i <= N - count; i++) {
				num *= 2;
				num *= i;
			}
			answer += num;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				makePermutation(count + 1, visited, left + gram[i], right);
				if (right + gram[i] <= left) {
					makePermutation(count + 1, visited, left, right + gram[i]);
				}
				visited[i] = false;
			}
		}
	}
}
