package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q1655_BOJ_가운데를말해요 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> small = new PriorityQueue<Integer>((e1, e2) -> {
			return e2 - e1;
		});
		PriorityQueue<Integer> big = new PriorityQueue<Integer>();

		small.add(Integer.parseInt(br.readLine()));
		sb.append(small.peek()).append("\n");

		for (int n = 1; n < N; n++) {
			int next = Integer.parseInt(br.readLine());

			if (n % 2 == 1) {
				if (small.peek() <= next) {
					big.add(next);
				} else {
					big.add(small.poll());
					small.add(next);
				}
			} else {
				if (big.peek() <= next) {
					small.add(big.poll());
					big.add(next);
				} else {
					small.add(next);
				}
			}

			sb.append(small.peek()).append("\n");
		}

		System.out.println(sb);
	}
}
