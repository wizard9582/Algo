package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q14938_BOJ_서강그라운드_다익스트라 {
	static StringTokenizer st;
	static ArrayList<ArrayList<Route>> list = new ArrayList<ArrayList<Route>>();
	static int N, M, R, answer = 0;
	static int[] items;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		items = new int[N + 1];
		list.add(new ArrayList<Route>());

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			items[n] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<Route>());
		}

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list.get(a).add(new Route(b, length));
			list.get(b).add(new Route(a, length));
		}

		for (int n = 1; n <= N; n++) {
			dijkstra(n);
		}

		System.out.println(answer);
	}

	private static void dijkstra(int start) {
		int[] routes = new int[N + 1];
		Arrays.fill(routes, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Route> pq = new PriorityQueue<Route>((e1, e2) -> {
			return e1.length - e2.length;
		});

		pq.offer(new Route(start, 0));
		routes[start] = 0;

		while (!pq.isEmpty()) {
			Route now = pq.poll();

			if (!visited[now.to]) {
				visited[now.to] = true;
			}
			ArrayList<Route> nowList = list.get(now.to);
			for (int i = 0; i < nowList.size(); i++) {
				Route next = nowList.get(i);
				if (!visited[next.to] && routes[next.to] > routes[now.to] + next.length) {
					routes[next.to] = routes[now.to] + next.length;
					pq.offer(new Route(next.to, routes[next.to]));
				}
			}
		}

		int sum = 0;
		for (int n = 1; n <= N; n++) {
			if (routes[n] <= M) {
				sum += items[n];
			}
		}
		answer = Math.max(answer, sum);
	}

	private static class Route {
		int to;
		int length;

		public Route(int to, int length) {
			super();
			this.to = to;
			this.length = length;
		}
	}
}
