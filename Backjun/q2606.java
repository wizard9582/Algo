package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2606 {
	static StringTokenizer st;
	static int[][] net;
	static int N;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		net = new int[N + 1][N + 1];
		int M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			net[a][b] = 1;
			net[b][a] = 1;
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (net[1][i] == 1) {
				queue.offer(i);
			}
		}
		net[1][1] = 1;

		while (!queue.isEmpty()) {
			int com = queue.poll();
			if (net[com][com] == 1) {
				continue;
			}else {
				net[com][com] = 1;
				answer++;
			}

			for (int i = 1; i <= N; i++) {
				if (net[com][i] == 1) {
					queue.offer(i);
				}
			}
		}

		System.out.println(answer);
	}
}
