package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11403 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int n = 0; n < N; n++) {
			visit = new boolean[N];
			visit[n] = true;
			dfs(n, n);
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				sb.append(map[n][m]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int target, int search) {

		for (int n = 0; n < N; n++) {
			if(map[search][n] == 1) {
				map[target][n] = 1;
				if(!visit[n]) {
					visit[n] = true;
					dfs(target, n);
				}
			}
		}

	}
}
