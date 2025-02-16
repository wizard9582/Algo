package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q15649 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		recur(M, new int[M], new boolean[N]);

		System.out.println(sb);
	}

	static void recur(int count, int[] choose, boolean[] use) {
		if (count == 0) {
			for (int i = 0; i < M; i++) {
				sb.append(choose[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!use[i]) {
				use[i] = true;
				choose[M - count] = i+1;
				recur(count - 1, choose, use);
				use[i] = false;
			}
		}
	}
}
