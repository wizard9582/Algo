package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q5430 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		String order;

		for (int n = 0; n < N; n++) {
			order = br.readLine();
			br.readLine();
			st = new StringTokenizer(br.readLine(), "[,]");
			boolean flag = true;
			boolean dir = true;
			boolean hasE = false;

			while (st.hasMoreTokens()) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			}

			for (int s = 0; s < order.length(); s++) {
				if (order.charAt(s) == 'R') {
					dir = !dir;
				} else {
					if (deque.isEmpty()) {
						flag = false;
						break;
					} else {
						if (dir) {
							deque.removeFirst();
						} else {
							deque.removeLast();
						}
					}
				}
			}

			if (flag) {
				sb.append("[");
				while (!deque.isEmpty()) {
					hasE = true;
					if (dir) {
						sb.append(deque.removeFirst()).append(",");
					} else {
						sb.append(deque.removeLast()).append(",");
					}
				}
				if (hasE) {
					sb = new StringBuilder(sb.substring(0, sb.length() - 1));
				}
				sb.append("]\n");
			} else {
				sb.append("error\n");
			}
			deque.clear();
		}

		System.out.println(sb);
	}
}
