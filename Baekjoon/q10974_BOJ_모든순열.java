package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10974_BOJ_모든순열 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] bit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		bit = new int[N];

		for (int n = 0; n < N; n++) {
			bit[n] = 1 << n;
		}

		dfs(0, new int[N], 0);

		System.out.println(sb);
	}

	static void dfs(int count, int[] choosed, int bitmask) {
		if (count == N) {
			for (int n = 0; n < N; n++) {
				sb.append(choosed[n] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int n = 0; n < N; n++) {
			if ((bitmask & bit[n]) == 0) {
				bitmask += bit[n];
				choosed[count] = n;
				dfs(count + 1, choosed, bitmask);
				bitmask -= bit[n];
			}
		}
	}
}