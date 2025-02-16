package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q20299 {
	static int N, S, M, x1, x2, x3, count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<int[]> queue = new LinkedList<>();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());

			if (memberCheck(x1, x2, x3)) {
				if (S <= x1 + x2 + x3) {
					count++;

					queue.add(new int[] {x1,x2,x3});
				}
			}
		}
		sb.append(count).append("\n");
		while (!queue.isEmpty()) {
			int[] member = queue.poll();
			sb.append(member[0]).append(" ").append(member[1]).append(" ").append(member[2]).append(" ");
		}
		System.out.println(sb);
	}

	static boolean memberCheck(int x1, int x2, int x3) {
		if (x1 < M)	return false;
		if (x2 < M)return false;
		if (x3 < M)return false;

		return true;
	}
}
