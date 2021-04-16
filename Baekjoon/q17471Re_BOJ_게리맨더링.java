package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17471Re_BOJ_게리맨더링 {
	static StringTokenizer st;
	static int N, max = 0, answer = Integer.MAX_VALUE;
	static int[] populations;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		populations = new int[N + 1];
		map = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			populations[n] = Integer.parseInt(st.nextToken());
			max += populations[n];
		}

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			for (int i = 0; i < a; i++) {
				int b = Integer.parseInt(st.nextToken());
				map[n][b] = true;
			}
		}

		powerset(1, populations[1], 2);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static void powerset(int count, int population, int use) {

		if (count == N) {
			if(graphCheck(use)) {
				answer = Math.min(answer, Math.abs(max - (2 * population)));
			}
			return;
		}
		powerset(count + 1, population, use);
		population += populations[count + 1];
		use = use | (1 << (count + 1));
		powerset(count + 1, population, use);
	}

	static boolean graphCheck(int team) {
		boolean[] red = new boolean[N + 1];
		boolean[] blue = new boolean[N + 1];
		int redX = 0, blueX = 0;

		for (int n = 1; n <= N; n++) {
			if ((team & (1 << n)) > 0) {
				red[n] = true;
				redX = n;
			} else {
				blue[n] = true;
				blueX = n;
			}
		}

		if (redX == 0 || blueX == 0) {
			return false;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(redX);
		red[redX] = false;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int n = 1; n <= N; n++) {
				if (map[now][n] && red[n]) {
					queue.offer(n);
					red[n] = false;
				}
			}
		}

		queue.offer(blueX);
		blue[blueX] = false;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int n = 1; n <= N; n++) {
				if (map[now][n] && blue[n]) {
					queue.offer(n);
					blue[n] = false;
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			if (red[n] || blue[n]) {
				return false;
			}
		}

		return true;
	}
}
