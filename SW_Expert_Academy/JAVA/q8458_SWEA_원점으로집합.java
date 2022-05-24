package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q8458_SWEA_원점으로집합 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			boolean flag = false;
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			long X = Integer.parseInt(st.nextToken());
			long Y = Integer.parseInt(st.nextToken());
			long odd = (Math.abs(X) + Math.abs(Y)) % 2;
			long gap = Math.max(0, Math.abs(X) + Math.abs(Y));

			for (int n = 1; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());

				if ((Math.abs(X) + Math.abs(Y)) % 2 != odd) {
					flag = true;
				}

				gap = Math.max(gap, Math.abs(X) + Math.abs(Y));
			}

			if (flag) {
				sb.append("#").append(tc).append(" -1").append("\n");
			} else {

				while (gap > 0) {
					answer++;
					gap -= answer;
				}
				answer = gap % 2 == 0 ? answer : (answer % 2 == 0 ? answer + 1 : answer + 2);

				sb.append("#").append(tc).append(" ").append(answer).append("\n");
			}
		}

		System.out.println(sb);
	}
}
