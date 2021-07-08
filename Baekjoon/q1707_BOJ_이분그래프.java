package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1707_BOJ_이분그래프 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			boolean flag = true;

			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] visited = new int[V + 1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int v = 0; v <= V; v++) {
				list.add(new ArrayList<Integer>());
			}

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());

				list.get(left).add(right);
				list.get(right).add(left);
			}

			loop: for (int v = 1; v < V; v++) {
				if (visited[v] == 0) {
					queue.offer(v);
					visited[v] = 1;
				}

				while (!queue.isEmpty()) {
					int now = queue.poll();
					int team = visited[now];
					ArrayList<Integer> nexts = list.get(now);

					for (int i = 0; i < nexts.size(); i++) {
						int next = nexts.get(i);
						if (visited[next] == 0) {
							queue.offer(next);
							visited[next] = (team == 1) ? 2 : 1;
						} else if (visited[next] == team) {
							flag = false;
							break loop;
						}
					}
				}
			}

			if (flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb);
	}
}