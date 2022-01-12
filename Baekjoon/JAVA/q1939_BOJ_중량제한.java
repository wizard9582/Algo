package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1939_BOJ_중량제한 {
	static StringTokenizer st;
	static int start, goal, N;
	static List<ArrayList<Bridge>> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Bridge>());
		}

		int min = 1;
		int max = 0;

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			max = Math.max(max, weight);
			list.get(from).add(new Bridge(to, weight));
			list.get(to).add(new Bridge(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());

		while (min <= max) {
			int center = (max + min) / 2;

			if (bfs(center)) {
				min = center + 1;
			} else {
				max = center - 1;
			}
		}

		System.out.println(max);
	}

	static boolean bfs(int check) {

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == goal) {
				return true;
			}

			List<Bridge> nowList = list.get(now);
			for (int s = 0; s < nowList.size(); s++) {
				Bridge next = nowList.get(s);
				if (!visited[next.to] && check <= next.weight) {
					queue.offer(next.to);
					visited[next.to] = true;
				}
			}
		}

		return false;
	}

	static class Bridge {
		int to, weight;

		Bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
