package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q18513_BOJ_샘터 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			queue.add(num);
			visited.add(num);
		}

		long answer = 0;
		int distance = 0;
		boolean flag = true;
		
		while (flag && !queue.isEmpty()) {
			int size = queue.size();
			distance++;
			while (flag && size-- > 0) {
				int now = queue.poll();

				int delta = 1;
				for(int i = 0; i < 2; i++) {
					int next = now + delta;
					delta = -1;
					if (!visited.contains(next)) {
						visited.add(next);
						queue.offer(next);
						K--;
						answer += distance;
					}

					if (K == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
