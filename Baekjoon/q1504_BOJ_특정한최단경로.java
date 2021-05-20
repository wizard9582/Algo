package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1504_BOJ_특정한최단경로 {
	static StringTokenizer st;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Node>());
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int relayA = Integer.parseInt(st.nextToken());
		int relayB = Integer.parseInt(st.nextToken());
		
		int[] distance = djikstra(1);
		int[] distanceA = djikstra(relayA);
		int[] distanceB = djikstra(relayB);
		
		int answer = -1;
		
		if(distance[relayA]!=Integer.MAX_VALUE && distanceA[relayB]!=Integer.MAX_VALUE && distanceB[N]!=Integer.MAX_VALUE) {
			answer = distance[relayA]+distanceA[relayB]+distanceB[N];
		}
		if(distance[relayB]!=Integer.MAX_VALUE && distanceB[relayA]!=Integer.MAX_VALUE && distanceA[N]!=Integer.MAX_VALUE) {
			if(answer == -1) {
				answer = distance[relayB]+distanceB[relayA]+distanceA[N];
			}else {
				answer = Math.min(answer, distance[relayB]+distanceB[relayA]+distanceA[N]);
			}
		}
		
		System.out.println(answer);
	}
	
	static int[] djikstra(int from) {
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2)->{
			return e1.weight - e2.weight;
		});
		
		distance[from] = 0;
		pq.add(new Node(from, 0));
		
		while(!pq.isEmpty()) {
			
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
		
		return distance;
		
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
