package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6603_BOJ_로또 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}

			arr = new int[N];

			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, new int[6]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int count, int start, int[] choosed) {
		if (count == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			choosed[count] = arr[i];
			dfs(count + 1, i + 1, choosed);
		}
	}
}
