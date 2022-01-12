package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q12851 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] visit = new int[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);

		int count = 0, answer = 0;
		boolean flag = false;

		while (!queue.isEmpty()) {

			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int x = queue.poll();

				if (x == M) {
					flag = true;
					count++;
					continue;
				}
				
				if(flag) {
					continue;
				}

				int nX = 2 * x;
				if (isIn(nX) && (visit[nX] == 0 || answer == visit[nX] - 1)) {
					visit[nX] = answer+1;
					queue.offer(nX);
				}

				nX = x - 1;
				if (isIn(nX) && (visit[nX] == 0 || answer == visit[nX] - 1)) {
					visit[nX] = answer+1;
					queue.offer(nX);
				}

				nX = x + 1;
				if (isIn(nX) && (visit[nX] == 0 || answer == visit[nX] - 1)) {
					visit[nX] = answer+1;
					queue.offer(nX);
				}
			}
			if (flag) {
				break;
			}
			answer ++;
		}

		System.out.println(answer);
		System.out.println(count);
	}

	static boolean isIn(int x) {
		if (0 <= x && x <= 100000) {
			return true;
		}
		return false;
	}
}
