package jungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1681_JO_해밀턴순환회로 {
	static StringTokenizer st;
	static int N, answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		visit[0] = true;
		dfs(0, 0, 0);

		System.out.println(answer);
	}

	static void dfs(int now, int cost, int count) {
		if (cost > answer) {
			return;
		}
		if (count == N - 1) {
			if (map[now][0] == 0) {
				return;
			} else {
				cost += map[now][0];
				answer = Math.min(cost, answer);
			}
		}

		for (int i = 1; i < N; i++) {
			if (!visit[i] && map[now][i] != 0) {
				visit[i] = true;
				dfs(i,cost+map[now][i],count+1);
				visit[i] = false;
			}
		}
	}
}
