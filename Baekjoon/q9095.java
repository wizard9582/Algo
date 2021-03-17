package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9095 {
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			count = 0;
			recur(N, new int[N], 0, 0);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void recur(int N, int[] choose, int sum, int idx) {
		if (sum == N) {
			count++;
			return;
		}
		if (sum > N) {
			return;
		}

		for (int i = 1; i < 4; i++) {
			choose[idx] = i;
			recur(N, choose, sum + i, idx + 1);
		}
	}
}
