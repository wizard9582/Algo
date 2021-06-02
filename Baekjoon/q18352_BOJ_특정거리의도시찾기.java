package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q18352_BOJ_특정거리의도시찾기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Integer>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(from).add(to);
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		queue.add(X);
		visited[X] = true;

		while (!queue.isEmpty() && K-- > 0) {
			int size = queue.size();
			while (size-- > 0) {
				int now = queue.poll();
				ArrayList<Integer> nowList = list.get(now);

				for (int i = 0; i < nowList.size(); i++) {
					int next = nowList.get(i);

					if (!visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
		}

		if (queue.isEmpty()) {
			System.out.println(-1);
		} else {
			LinkedList<Integer> answer = new LinkedList<>();

			while (!queue.isEmpty()) {
				answer.add(queue.poll());
			}

			Collections.sort(answer);
			while (answer.size() != 0) {
				sb.append(answer.poll()).append("\n");
			}

		}

		System.out.println(sb);
	}
}
