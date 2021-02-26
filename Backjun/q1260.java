package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1260 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[] visit;
	static int N,M,V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		visit = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		visit = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		while (!queue.isEmpty()) {
			int next = queue.poll();
			if (!visit[next]) {
				sb.append(next + " ");
				visit[next] = true;
			}

			for (int n = 1; n <= N; n++) {
				if (map[next][n] == 1 && !visit[n]) {
					queue.offer(n);
				}
			}
		}

		System.out.println(sb);
	}

	static void dfs(int x) {
		visit[x] = true;
		sb.append(x + " ");
		
		for (int n = 1; n <= N; n++) {
			if (map[x][n] == 1 && !visit[n]) {
				dfs(n);
			}
		}

	}
}
