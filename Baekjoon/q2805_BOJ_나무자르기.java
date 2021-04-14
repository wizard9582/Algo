package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2805_BOJ_나무자르기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		long min = 1, max = 0;
		for (int n = 0; n < N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[n]);
		}

		while (min <= max) {
			long center = (min + max) / 2;
			long cut = 0;

			for (int n = 0; n < N; n++) {
				cut += Math.max(tree[n] - center, 0);
			}

			if (cut >= M) {
				min = center+1;
			} else {
				max = center-1;
			}
		}

		System.out.println(max);
	}
}
