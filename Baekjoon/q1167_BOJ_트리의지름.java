package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1167_BOJ_트리의지름 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<ArrayList<Edge>> list = new ArrayList<>();

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Edge>());
		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());

			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());

				list.get(from).add(new Edge(to, weight));
			}
		}

		int max = 0, start = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, 0 });
		visited[1] = true;

		while (!queue.isEmpty()) {
			int now = queue.peek()[0];
			int w = queue.poll()[1];

			ArrayList<Edge> nowList = list.get(now);

			for (int s = 0; s < nowList.size(); s++) {
				Edge e = nowList.get(s);

				if (!visited[e.to]) {
					visited[e.to] = true;
					int nW = w + e.weight;
					queue.offer(new int[] { e.to, nW });

					if (nW > max) {
						max = nW;
						start = e.to;
					}
				}
			}
		}

		max = 0;
		queue.offer(new int[] { start, 0 });
		visited = new boolean[N + 1];
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.peek()[0];
			int w = queue.poll()[1];

			ArrayList<Edge> nowList = list.get(now);

			for (int s = 0; s < nowList.size(); s++) {
				Edge e = nowList.get(s);

				if (!visited[e.to]) {
					visited[e.to] = true;
					int nW = w + e.weight;
					queue.offer(new int[] { e.to, nW });
					max = Math.max(max, nW);
				}
			}
		}

		System.out.println(max);
	}

	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
