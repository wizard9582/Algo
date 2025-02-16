package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2529_BOJ_부등호 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static boolean[] type;
	static boolean[] numbers = new boolean[10];
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		type = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			if (st.nextToken().charAt(0) == '<') {
				type[n] = true;
			}
		}

		for (int i = 9; i >= 0; i--) {
			numbers[i] = true;
			dfs1(0, i, i);
			numbers[i] = false;
		}
		flag = false;
		for (int i = 0; i < 10; i++) {
			numbers[i] = true;
			dfs2(0, i, i);
			numbers[i] = false;
		}

		System.out.println(sb);
	}

	static void dfs1(int idx, long sum, int before) {
		if (flag) {
			return;
		}
		if (idx == N) {
			flag = true;
			if (sum < Math.pow(10, N)) {
				sb.append(0);
			}
			sb.append(sum).append("\n");
			return;
		}

		for (int i = 9; i >= 0; i--) {
			if (!numbers[i] && check(idx, before, i)) {
				numbers[i] = true;
				dfs1(idx + 1, sum * 10 + i, i);
				numbers[i] = false;
			}
		}
	}

	static void dfs2(int idx, long sum, int before) {
		if (flag) {
			return;
		}
		if (idx == N) {
			flag = true;
			if (sum < Math.pow(10, N)) {
				sb.append(0);
			}
			sb.append(sum).append("\n");
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!numbers[i] && check(idx, before, i)) {
				numbers[i] = true;
				dfs2(idx + 1, sum * 10 + i, i);
				numbers[i] = false;
			}
		}

	}

	static boolean check(int idx, int before, int next) {
		if (type[idx]) {
			if (before < next) {
				return true;
			}
		} else {
			if (before > next) {
				return true;
			}
		}
		return false;
	}
}
