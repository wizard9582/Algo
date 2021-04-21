package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5643_SWEA_키순서 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());

			List<ArrayList<Integer>> shorter = new ArrayList<>();
			for (int n = 0; n <= N; n++) {
				shorter.add(new ArrayList<Integer>());
			}
			List<ArrayList<Integer>> taller = new ArrayList<>();
			for (int n = 0; n <= N; n++) {
				taller.add(new ArrayList<Integer>());
			}

			int M = Integer.parseInt(br.readLine());

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				shorter.get(b).add(a);
				taller.get(a).add(b);
			}

			for (int n = 1; n <= N; n++) {
				boolean[] visited = new boolean[N + 1];
				Queue<Integer> queue = new LinkedList<>();
				int count = 0;
				visited[n] = true;
				queue.offer(n);

				while (!queue.isEmpty()) {
					ArrayList<Integer> list = shorter.get(queue.poll());
					for (int s = 0; s < list.size(); s++) {
						int next = list.get(s);
						if (!visited[next]) {
							queue.offer(next);
							visited[next] = true;
							count++;
						}
					}
				}

				visited = new boolean[N + 1];
				visited[n] = true;
				queue.offer(n);

				while (!queue.isEmpty()) {
					ArrayList<Integer> list = taller.get(queue.poll());
					for (int s = 0; s < list.size(); s++) {
						int next = list.get(s);
						if (!visited[next]) {
							queue.offer(next);
							visited[next] = true;
							count++;
						}
					}
				}

				if (count == N - 1) {
					answer++;
				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
