package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q20304Re{
	static StringTokenizer st;
	static int N, M, depth;
	static int[] attacks;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		attacks = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			attacks[m] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		for (int m = 0; m < M; m++) {
			queue.offer(attacks[m]);
			visited[attacks[m]] = true;
		}

		for (depth = 0; !queue.isEmpty();) {
			int size = queue.size();
			for (int s = size; s > 0; s--) {
				int front = queue.poll();

				for (int i = 1; i <= N; i <<= 1) {
					int next = front ^ i;

					if (next <= N && !visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
			depth ++;
		}

		System.out.println(depth-1);
	}
}
