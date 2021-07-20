package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class q7662_BOJ_이중우선순위큐 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();

			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if (cmd == 'I') {
					if (tm.containsKey(num)) {
						tm.put(num, tm.get(num) + 1);
					} else {
						tm.put(num, 1);
					}
				} else if (!tm.isEmpty()) {
					int target = (num == 1) ? tm.lastKey() : tm.firstKey();

					if (tm.containsKey(target)) {
						if (tm.get(target) > 1) {
							tm.put(target, tm.get(target) - 1);
						} else {
							tm.remove(target);
						}
					}
				}
			}

			if (tm.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			}
		}

		System.out.println(sb);
	}
}