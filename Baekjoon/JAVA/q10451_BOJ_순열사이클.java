package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10451_BOJ_순열사이클 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int answer = 0;

			int[] num = new int[N + 1];

			for (int n = 1; n <= N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}

			for (int n = 1; n <= N; n++) {
				if (num[n] != 0) {
					answer++;
					int now = n;
					int next = num[n];
					while (num[next] != 0) {
						next = num[now];
						num[now] = 0;
						now = next;
					}
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
