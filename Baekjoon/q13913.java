package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q13913 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100001];
		int[] from = new int[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		int time = 0;

		loop : while (!queue.isEmpty()) {

			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int x = queue.poll();

				if (x == M) {
					break loop;
				}

				int nX = 2 * x;
				if (isIn(nX) && !visit[nX]) {
					visit[nX] = true;
					queue.offer(nX);
					from[nX] = x;
				}

				nX = x - 1;
				if (isIn(nX) && !visit[nX]) {
					visit[nX] = true;
					queue.offer(nX);
					from[nX] = x;
				}

				nX = x + 1;
				if (isIn(nX) && !visit[nX]) {
					visit[nX] = true;
					queue.offer(nX);
					from[nX] = x;
				}
			}
			time++;
		}

		Stack<Integer> stack = new Stack<>();

		 while (M != N){
			stack.push(M);
			M = from[M];
		}

		sb.append(time).append("\n");
		sb.append(N).append(" ");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
	}

	static boolean isIn(int x) {
		if (0 <= x && x <= 100000) {
			return true;
		}
		return false;
	}
}
