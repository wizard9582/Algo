package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1753 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, K;
	static LinkNode[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		graph = new LinkNode[V + 1];

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from] = new LinkNode(to, weight, graph[from]);
		}

		dijkstra(K);

		System.out.println(sb);
	}

	static void dijkstra(int start) {

		boolean[] visit = new boolean[V + 1];
		int[] dist = new int[V + 1];

		int inf = 1000000;
		Arrays.fill(dist, inf);
		dist[start] = 0;

		for (int v = 1; v <= V; v++) {
			int minVer = 0, minCost = inf;
			
			for (int i = 1; i <= V; i++) {
				if(!visit[i] && dist[i] < minCost) {
					minVer = i;
					minCost = dist[i];
				}
			}
			
			visit[minVer] = true;
			LinkNode child = graph[minVer];
			
			while(child != null) {
				if(!visit[child.i] && dist[child.i] > dist[minVer] + child.cost) {
					dist[child.i] = dist[minVer] + child.cost;
				}
				child = child.pre;
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

	static class LinkNode {
		int i, cost;
		LinkNode pre;

		public LinkNode(int i, int cost, LinkNode pre) {
			super();
			this.i = i;
			this.cost = cost;
			this.pre = pre;
		}

	}
}
