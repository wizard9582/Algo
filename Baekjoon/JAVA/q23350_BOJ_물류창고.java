package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q23350_BOJ_물류창고 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<int[]>();
		Stack<int[]> stay = new Stack<int[]>();
		Stack<int[]> stack = new Stack<int[]>();
		int work = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] count = new int[M + 1];
		int target = M;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int priority = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			count[priority]++;

			queue.offer(new int[] { priority, weight });
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == target) {

				while (!stack.isEmpty()) {
					int[] top = stack.peek();
					if (top[0] == now[0] && top[1] < now[1]) {
						work += top[1] * 2;
						stay.push(stack.pop());
					} else {
						break;
					}
				}

				stack.push(now);
				work += now[1];

				while (!stay.isEmpty()) {
					stack.push(stay.pop());
				}

				count[target]--;
				if (count[target] == 0) {
					target--;
				}
			} else {
				work += now[1];
				queue.offer(now);
			}
		}

		System.out.println(work);
	}
}
