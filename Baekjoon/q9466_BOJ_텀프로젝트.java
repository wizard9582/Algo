package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9466_BOJ_텀프로젝트 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, answer;
	static int[] map;
	static boolean[] visit;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1];
			visit = new boolean[N + 1];
			check = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());

			for (int n = 1; n <= N; n++) {
				map[n] = Integer.parseInt(st.nextToken());
			}

			for (int n = 1; n <= N; n++) {
				if (!check[n]) {
					dfs(n);
				}
			}

			sb.append(N - answer).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int n) {
		if (check[n]) {
			return;
		}

		if (!visit[n]) {
			visit[n] = true;
			dfs(map[n]);
		} else {
			answer ++;
			int now = map[n];
			while(now!=n) {
				answer++;
				now = map[now];
			}
		}

		check[n] = true;
	}
}
