package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1753Re {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, K;
	static ArrayList<ArrayList> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		for (int v = 0; v <= V; v++) {
			list.add(new ArrayList<Node>());
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, weight));
		}

		dijkstra(K);

		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[V + 1];
		int[] dist = new int[V + 1];

		int inf = 1000000;
		Arrays.fill(dist, inf);
		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int to = now.to;

			if (!visit[to]) {
				visit[to] = true;

				for (int i = 0; i < list.get(to).size(); i++) {
					
					Node node = (Node) list.get(to).get(i);
					
					if (dist[node.to] > dist[to] + node.cost) {
						dist[node.to] = dist[to] + node.cost;
						queue.add(new Node(node.to, dist[node.to]));
					}
				}
			}
		}

		for (int v = 1; v <= V; v++) {
			if (dist[v] == inf) {
				sb.append("INF\n");
			} else {
				sb.append(dist[v]).append("\n");
			}
		}
	}

	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}

	}
}
