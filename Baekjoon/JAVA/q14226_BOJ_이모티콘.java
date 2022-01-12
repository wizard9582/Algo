package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class q14226_BOJ_이모티콘 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int S = Integer.parseInt(br.readLine());
		int range = 2 * S;
		boolean[][] visited = new boolean[range][range];
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { 1, 0 });
		visited[1][0] = true;

		int answer = 0;

		loop: while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				int now = queue.peek()[0];
				int clip = queue.poll()[1];

				if (now == S) {
					break loop;
				}

				int next = now + clip;
				if (next < range && !visited[next][clip]) {
					visited[next][clip] = true;
					queue.offer(new int[] { next, clip });
				}
				next = now - 1;
				if (0 < next && !visited[next][clip]) {
					visited[next][clip] = true;
					queue.offer(new int[] { next, clip });
				}
				clip = now;
				if (!visited[next][clip]) {
					visited[next][clip] = true;
					queue.offer(new int[] { now, clip });
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}
