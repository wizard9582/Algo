package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1916_BOJ_최소비용구하기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Node>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> {
			return e1.weight - e2.weight;
		});

		distance[from] = 0;
		pq.add(new Node(from, 0));

		while (!pq.isEmpty()) {

			int now = pq.poll().to;

			if (!visited[now]) {
				visited[now] = true;

				ArrayList<Node> nowList = list.get(now);

				for (int i = 0; i < nowList.size(); i++) {
					Node next = nowList.get(i);

					if (!visited[next.to]) {
						distance[next.to] = Math.min(distance[next.to], distance[now] + next.weight);
						pq.add(new Node(next.to, distance[next.to]));
					}
				}

			}
		}

		System.out.println(distance[to]);
	}

	static class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
