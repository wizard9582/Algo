package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2960_BOJ_에라토스테네스의체 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[N + 1];

		loop: for (int n = 2; n <= N; n++) {
			if (!num[n]) {
				for (int i = 1; i * n <= N; i++) {
					if (!num[i * n]) {
						num[i * n] = true;
						K--;
						if (K == 0) {
							System.out.println(i * n);
							break loop;
						}
					}
				}
			}
		}
	}
}
