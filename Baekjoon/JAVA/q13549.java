package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q13549 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N >= M) {
			System.out.println(N - M);
			return;
		}

		int[] dp = new int[200001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		Deque<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(N, 0));
		dp[N] = 0;

		while (!queue.isEmpty()) {
			Pair now = queue.pollFirst();

			int time = now.time;
			int position = now.position;

			if (dp[position] < time) {
				continue;
			}

			dp[position] = time;

			int nP = position * 2;
			if (isIn(nP) && time < dp[nP]) {
				dp[nP] = time;
				queue.addFirst(new Pair(nP, time));
			}

			nP = position + 1;
			if (isIn(nP) && time + 1 < dp[nP]) {
				dp[nP] = time + 1;
				queue.addLast(new Pair(nP, time + 1));
			}

			nP = position - 1;
			if (isIn(nP) && time + 1 < dp[nP]) {
				dp[nP] = time + 1;
				queue.addLast(new Pair(nP, time + 1));
			}
		}

		System.out.println(dp[M]);
	}

	static class Pair {
		int position, time;

		Pair(int p, int t) {
			this.position = p;
			this.time = t;
		}
	}

	static boolean isIn(int x) {
		if (0 <= x && x < 200001) {
			return true;
		}
		return false;
	}
}
