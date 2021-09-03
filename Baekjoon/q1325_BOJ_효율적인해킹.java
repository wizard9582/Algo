package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1325_BOJ_효율적인해킹 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] answer = new int[N + 1];

		ArrayList<Integer>[] list = new ArrayList[N+1];

		for (int n = 1; n <= N; n++) {
			list[n] = new ArrayList<Integer>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
		}

		for (int n = 1; n <= N; n++) {
			visited = new boolean[N + 1];
			visited[n] = true;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(n);

			while (!queue.isEmpty()) {
				int now = queue.poll();

				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					if (!visited[next]) {
						visited[next] = true;
						answer[next]++;
						queue.offer(next);
					}
				}
			}
		}
		
		int max = 0;
		for (int n = 1; n <= N; n++) {
			max = Math.max(max, answer[n]);
		}
		for (int n = 1; n <= N; n++) {
			if(answer[n] == max) {
				sb.append(n).append(" ");	
			}
		}

		System.out.println(sb.toString());
	}
}
